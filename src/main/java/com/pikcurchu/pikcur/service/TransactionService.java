package com.pikcurchu.pikcur.service;

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

//    public ResStoreInfoDto selectShippingStatus(Integer transactionId) {
//    }

    public void insertTrackingNumber(Integer transactionId, String trackingNumber, String company) {
        transactionMapper.insertShippingInfo(transactionId, trackingNumber,company);
    }

    public void confirmPurchase(Integer transactionId) {
        transactionMapper.updateTransactionStatus(transactionId);
    }
}
