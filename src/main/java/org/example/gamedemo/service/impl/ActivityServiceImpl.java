package org.example.gamedemo.service.impl;

import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Activity;
import org.example.gamedemo.mapper.ActivityMapper;
import org.example.gamedemo.service.IActivityService;
import org.example.gamedemo.state.AbstractState;
import org.example.gamedemo.state.ActivityStateContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ActivityServiceImpl implements IActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private ActivityStateContext activityStateContext;

    @Override
    public Result getActivityList() {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result getActivityDetail(Long activityId) {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result createActivity() {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result updateActivity() {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result deleteActivity(Long activityId) {
        // 这里可以添加具体的业务逻辑
        return null;
    }

    @Override
    public Result arraignment(Long activityId) {
//        Activity activity = activityMapper.selectById(activityId);
//        if (activity != null) {
//            boolean result = activityStateContext.arraignment(activityId, activity.getStatus());
//            // 修改此处
//            return Result.ok(result);
//        }
        return Result.fail("活动不存在");
    }

    @Override
    public Result checkPass(Long activityId) {
//        Activity activity = activityMapper.selectById(activityId);
//        if (activity != null) {
//            boolean result = activityStateContext.checkPass(activityId, activity.getStatus());
//            // 修改此处
//            return Result.ok(result);
//        }
        return Result.fail("活动不存在");
    }

    @Override
    public Result checkRefuse(Long activityId) {
//        Activity activity = activityMapper.selectById(activityId);
//        if (activity != null) {
//            boolean result = activityStateContext.checkRefuse(activityId, activity.getStatus());
//            // 修改此处
//            return Result.ok(result);
//        }
        return Result.fail("活动不存在");
    }

    @Override
    public Result checkRevoke(Long activityId) {
//        Activity activity = activityMapper.selectById(activityId);
//        if (activity != null) {
//            boolean result = activityStateContext.checkRevoke(activityId, activity.getStatus());
//            // 修改此处
//            return Result.ok(result);
//        }
        return Result.fail("活动不存在");
    }

    @Override
    public Result close(Long activityId) {
//        Activity activity = activityMapper.selectById(activityId);
//        if (activity != null) {
//            boolean result = activityStateContext.close(activityId, activity.getStatus());
//            // 修改此处
//            return Result.ok(result);
//        }
        return Result.fail("活动不存在");
    }

    @Override
    public Result open(Long activityId) {
//        Activity activity = activityMapper.selectById(activityId);
//        if (activity != null) {
//            boolean result = activityStateContext.open(activityId, activity.getStatus());
//            // 修改此处
//            return Result.ok(result);
//        }
        return Result.fail("活动不存在");
    }

    @Override
    public Result doing(Long activityId) {
//        Activity activity = activityMapper.selectById(activityId);
//        if (activity != null) {
//            boolean result = activityStateContext.doing(activityId, activity.getStatus());
//            // 修改此处
//            return Result.ok(result);
//        }
        return Result.fail("活动不存在");
    }
}