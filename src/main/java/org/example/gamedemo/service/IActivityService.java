package org.example.gamedemo.service;

import org.example.gamedemo.dto.Result;

public interface IActivityService {
    Result getActivityList();
    Result getActivityDetail(Long activityId);
    Result createActivity();
    Result updateActivity();
    Result deleteActivity(Long activityId);

    // 状态流转方法
    Result arraignment(Long activityId);
    Result checkPass(Long activityId);
    Result checkRefuse(Long activityId);
    Result checkRevoke(Long activityId);
    Result close(Long activityId);
    Result open(Long activityId);
    Result doing(Long activityId);
}