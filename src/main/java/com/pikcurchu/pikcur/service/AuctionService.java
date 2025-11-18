package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.mapper.BidMapper;
import com.pikcurchu.pikcur.mapper.GoodsMapper;
import com.pikcurchu.pikcur.mapper.TransactionsMapper;
import com.pikcurchu.pikcur.vo.Bid;
import com.pikcurchu.pikcur.vo.Goods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final GoodsMapper goodsMapper;
    private final BidMapper bidMapper;

    @Transactional
    public void processExpiredAuctions() {

        // 1. 종료된 경매 조회
        List<Goods> expiredGoods = goodsMapper.findExpiredGoods();

        for (Goods goods : expiredGoods) {

            // 2. 최고가 입찰자 조회
            Bid topBid = bidMapper.findTopBidder(goods.getGoodsId());

            if (topBid != null) {
                bidMapper.updateBidStatus("03", topBid.getGoodsId(), topBid.getBidId() );
                goodsMapper.updateGoodsStatus("02", goods.getGoodsId());

            } else {
                // 유찰 처리
                goodsMapper.updateGoodsStatus("04", goods.getGoodsId());
            }
        }
    }

    @Transactional
    public void processUnpaidBids() {
        // 1. 낙찰된 지 3일 지났는데, 아직 결제 안 된(Goods가 '02'인) 입찰 건 조회
        List<Bid> unpaidBids = bidMapper.findUnpaidWinners();

        for (Bid oldWinner : unpaidBids) {

            // 2. 기존 낙찰자 '낙찰취소(04)' 처리
            bidMapper.updateBidStatus("04", oldWinner.getGoodsId(), oldWinner.getBidId());

            // (선택사항) 기존 낙찰자에게 "미결제로 취소됨" 알림 발송 로직 추가

            // 3. 차순위 입찰자 찾기
            Bid nextBidder = bidMapper.findNextBidder(oldWinner.getGoodsId());

            if (nextBidder != null) {
                // 4-A. 차순위자 있음 -> 새로운 '낙찰(03)' 지정
                // updateBidStatus가 실행되면서 update_date가 NOW()로 찍히므로,
                // 오늘부터 다시 3일 카운트가 시작됩니다.
                bidMapper.updateBidStatus("03", nextBidder.getGoodsId(), nextBidder.getBidId());

                // (선택사항) 새 낙찰자에게 "축하합니다! 기회가 왔습니다" 알림/문자 발송

            } else {
                // 4-B. 차순위자 없음 -> 상품 완전 '유찰(04)' 처리
                goodsMapper.updateGoodsStatus("04", oldWinner.getGoodsId());
            }
        }
    }
}
