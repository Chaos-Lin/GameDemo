package org.example.gamedemo.service.impl;

import org.example.gamedemo.dto.Result;
import org.example.gamedemo.mapper.LotteryMapper;
import org.example.gamedemo.service.ILotteryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LotteryServiceImpl implements ILotteryService {

    @Resource
    private LotteryMapper lotteryMapper;

    @Override
    public Result startLottery() {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result participateLottery() {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result getLotteryResult(Long userId) {
        // 这里可以添加具体的业务逻辑
        return null;
    }
}