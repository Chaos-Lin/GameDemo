package org.example.gamedemo.service;

import org.example.gamedemo.dto.Result;

public interface ILotteryService {
    Result startLottery();
    Result participateLottery();
    Result getLotteryResult(Long userId);
}