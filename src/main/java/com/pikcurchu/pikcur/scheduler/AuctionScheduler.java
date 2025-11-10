package com.pikcurchu.pikcur.scheduler;

import com.pikcurchu.pikcur.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuctionScheduler {

    private final AuctionService auctionService;

    @Scheduled(fixedRate = 60000) // 1분마다
    public void runAuctionCheck() {
        auctionService.processExpiredAuctions();
    }
}

