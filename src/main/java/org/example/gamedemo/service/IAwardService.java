package org.example.gamedemo.service;

import org.example.gamedemo.dto.Result;

public interface IAwardService {
    Result issueAward(Long userId, Long awardId);
    Result getAwardList(Long userId);
    Result claimAward(Long userId, Long awardId);
}