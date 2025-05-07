package org.example.gamedemo.state;

import org.example.gamedemo.entity.Activity;

public class EditingState extends AbstractState {

    @Override
    public boolean arraignment(Long activityId, Integer currentStatus) {
        // 实现活动提审逻辑
        System.out.println("活动提审，活动 ID: " + activityId);
        return true;
    }

    @Override
    public boolean checkPass(Long activityId, Integer currentStatus) {
        // 编辑状态不能直接审核通过
        System.out.println("编辑状态不能直接审核通过，活动 ID: " + activityId);
        return false;
    }

    @Override
    public boolean checkRefuse(Long activityId, Integer currentStatus) {
        // 编辑状态不能直接审核拒绝
        System.out.println("编辑状态不能直接审核拒绝，活动 ID: " + activityId);
        return false;
    }

    @Override
    public boolean checkRevoke(Long activityId, Integer currentStatus) {
        // 编辑状态无需撤审
        System.out.println("编辑状态无需撤审，活动 ID: " + activityId);
        return false;
    }

    @Override
    public boolean close(Long activityId, Integer currentStatus) {
        // 实现活动关闭逻辑
        System.out.println("活动关闭，活动 ID: " + activityId);
        return true;
    }

    @Override
    public boolean open(Long activityId, Integer currentStatus) {
        // 编辑状态不能直接开启
        System.out.println("编辑状态不能直接开启，活动 ID: " + activityId);
        return false;
    }

    @Override
    public boolean doing(Long activityId, Integer currentStatus) {
        // 编辑状态不能直接执行
        System.out.println("编辑状态不能直接执行，活动 ID: " + activityId);
        return false;
    }
}