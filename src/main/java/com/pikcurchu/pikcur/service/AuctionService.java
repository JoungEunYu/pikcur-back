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
    private final TransactionsMapper transMapper;

    @Transactional
    public void processExpiredAuctions() {

        // 1. 종료된 경매 조회
        List<Goods> expiredGoods = goodsMapper.findExpiredGoods();

        for (Goods goods : expiredGoods) {

            // 2. 최고가 입찰자 조회
            Bid topBid = bidMapper.findTopBidder(goods.getGoodsId());

            if (topBid != null) {
                // 3. 거래 생성(낙찰)
                Integer sellerNo = goodsMapper.selectMemberNoOfStore(goods.getStoreId());
                transMapper.createTransaction(
                        topBid.getMemberNo(),
                        sellerNo,
                        goods.getGoodsId(),
                        topBid.getBidPrice()
                );

                // 4. 입찰, 상품 상태 변경(낙찰)
                bidMapper.updateBidStatus("03", topBid.getGoodsId(), topBid.getBidId() );
                goodsMapper.updateGoodsStatus("02", goods.getGoodsId());

            } else {
                // 유찰 처리
                goodsMapper.updateGoodsStatus("04", goods.getGoodsId());
            }
        }
    }
}
