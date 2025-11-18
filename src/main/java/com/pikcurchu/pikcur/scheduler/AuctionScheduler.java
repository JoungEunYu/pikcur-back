package com.pikcurchu.pikcur.scheduler;

import com.pikcurchu.pikcur.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuctionScheduler {

    private final AuctionService auctionService;

    /**
     * 경매 종료 체크
     */
    @Scheduled(fixedRate = 1 * 60 * 1000) // 1분마다
    public void checkExpired() {
        auctionService.processExpiredAuctions();
    }

    /**
     * 낙찰 - 미결제자 체크
     */
    @Scheduled(fixedRate = 60 * 60 * 1000) // 1시간마다
    public void checkUnpaid() {
        auctionService.processUnpaidBids();
    }
}

