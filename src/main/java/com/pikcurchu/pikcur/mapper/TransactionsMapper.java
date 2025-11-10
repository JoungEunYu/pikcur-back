package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqShippingDto;
import com.pikcurchu.pikcur.dto.response.ResTransactionDetailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionsMapper {
    ResTransactionDetailDto findTransactionInfoById(Integer transactionId);

    void insertShippingInfo(ReqShippingDto reqShippingDto);

    void updateTransactionStatus(Integer transactionId);

    void createTransaction(Integer buyerNo, Integer sellerNo, Integer goodsId, Integer bidPrice);
}
