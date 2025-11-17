package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqVerifyPaymentDto;
import com.pikcurchu.pikcur.mapper.GoodsMapper;
import com.pikcurchu.pikcur.mapper.PaymentMapper;
import com.pikcurchu.pikcur.mapper.TransactionsMapper;
import com.pikcurchu.pikcur.vo.Payment;
import com.pikcurchu.pikcur.vo.Transactions;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final GoodsMapper goodsMapper;
    private final PaymentMapper paymentMapper;
    private final TransactionsMapper transactionMapper;
    private final IamportClient iamportClient;

    @Transactional
    public boolean verifyPayment(ReqVerifyPaymentDto dto, Integer memberNo) {
        try {
            // A. 아임포트 API에 '진짜' 결제 정보 요청 (서버 to 서버)
            IamportResponse<com.siot.IamportRestClient.response.Payment> iamportResponse = iamportClient.paymentByImpUid(dto.getImpUid());

            // B. 아임포트에서 가져온 '실제 결제 금액'
            BigDecimal paidAmountFromIamport = iamportResponse.getResponse().getAmount();

            // C. 프론트에서 보낸 '결제 요청 금액' (DB에서 가져오는 것을 더 추천합니다)
            BigDecimal paidAmountFromDto = dto.getAmount(); // 또는 long/int

            // D. 금액 위/변조 검증 (핵심!)
            // 주의: int/long 비교 대신 BigDecimal의 compareTo 사용
            if (paidAmountFromIamport.compareTo(paidAmountFromDto) != 0) {
                // 금액이 일치하지 않음 -> 위/변조 시도 또는 오류
                // (나중에 여기도 '강제 환불' 로직을 넣어야 합니다)
                return false;
            }

            // 검증 성공! 이제 DB 작업

            // 1. 상품(Goods) 상태 변경
            // TODO: integer로 결과 확인 하도록 수정
            goodsMapper.updateGoodsStatus("03", dto.getGoodsId());
            Integer sellerNo = goodsMapper.selectGoodsMemberNo(dto.getGoodsId());
            // 3. 거래 내역(TransactionHistory) 추가
            Transactions transactions = Transactions.builder()
                    .buyerNo(memberNo)
                    .sellerNo(sellerNo)
                    .price(paidAmountFromIamport.intValue())
                    .goodsId(dto.getGoodsId())
                    .build();

            transactionMapper.insertTranaction(transactions);

            // 2. 결제 정보(Payment) 저장
            Payment payment = Payment.builder()
                    .paymentId(dto.getImpUid())
                    .transactionId(transactions.getTransactionId())
                    .paymentMethod("inicis")
                    .paymentPrice(paidAmountFromIamport.intValue()) // DTO 금액이 아닌, 아임포트가 보증한 금액을 저장
                    .build();

            paymentMapper.insertPayment(payment);

            return true;

        } catch (Exception e) {
            // TODO: (중요) 이 경우, 이미 결제된 10원은 '강제 환불' API를 호출해야 합니다.
            e.printStackTrace(); // ⬅️⬅️⬅️ 이게 제일 중요합니다
            throw new RuntimeException("DB 작업 실패로 롤백합니다.", e);
        }
    }
}
