package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqShippingDto;
import com.pikcurchu.pikcur.dto.response.ResTransactionDetailDto;
import com.pikcurchu.pikcur.mapper.TransactionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionsMapper transactionMapper;
    public ResTransactionDetailDto selectTransactionInfo(Integer transactionId) {
        return transactionMapper.findTransactionInfoById(transactionId);
    }

    public void insertShippingInfo(Integer transactionId, ReqShippingDto reqShippingDto) {
        reqShippingDto.setTransactionId(transactionId);
        transactionMapper.insertShippingInfo(reqShippingDto);
    }

    public void confirmPurchase(Integer transactionId) {
        transactionMapper.updateTransactionStatus(transactionId);
    }
}
