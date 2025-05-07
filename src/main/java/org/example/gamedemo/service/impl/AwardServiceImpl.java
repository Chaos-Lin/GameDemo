package org.example.gamedemo.service.impl;

import org.example.gamedemo.dto.Result;
import org.example.gamedemo.mapper.AwardMapper;
import org.example.gamedemo.service.IAwardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AwardServiceImpl implements IAwardService {

    @Resource
    private AwardMapper awardMapper;

    @Override
    public Result issueAward(Long userId, Long awardId) {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result getAwardList(Long userId) {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result claimAward(Long userId, Long awardId) {
        // 这里可以添加具体的业务逻辑
        return null;
    }
}