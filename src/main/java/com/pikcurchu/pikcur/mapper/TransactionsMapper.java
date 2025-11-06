package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.ResTransactionDetailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionsMapper {
    ResTransactionDetailDto findTransactionInfoById(Integer transactionId);

    void insertShippingInfo(Integer transactionId, String trackingNumber, String company);

    void updateTransactionStatus(Integer transactionId);
}
