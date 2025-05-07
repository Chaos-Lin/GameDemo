package org.example.gamedemo.state;

import org.example.gamedemo.entity.Activity;

public abstract class AbstractState {

    /**
     * 活动提审
     * @param activityId 活动 ID
     * @param currentStatus 当前状态
     * @return 操作结果
     */
    public abstract boolean arraignment(Long activityId, Integer currentStatus);

    /**
     * 审核通过
     * @param activityId 活动 ID
     * @param currentStatus 当前状态
     * @return 操作结果
     */
    public abstract boolean checkPass(Long activityId, Integer currentStatus);

    /**
     * 审核拒绝
     * @param activityId 活动 ID
     * @param currentStatus 当前状态
     * @return 操作结果
     */
    public abstract boolean checkRefuse(Long activityId, Integer currentStatus);

    /**
     * 撤审撤销
     * @param activityId 活动 ID
     * @param currentStatus 当前状态
     * @return 操作结果
     */
    public abstract boolean checkRevoke(Long activityId, Integer currentStatus);

    /**
     * 活动关闭
     * @param activityId 活动 ID
     * @param currentStatus 当前状态
     * @return 操作结果
     */
    public abstract boolean close(Long activityId, Integer currentStatus);

    /**
     * 活动开启
     * @param activityId 活动 ID
     * @param currentStatus 当前状态
     * @return 操作结果
     */
    public abstract boolean open(Long activityId, Integer currentStatus);

    /**
     * 活动执行
     * @param activityId 活动 ID
     * @param currentStatus 当前状态
     * @return 操作结果
     */
    public abstract boolean doing(Long activityId, Integer currentStatus);
}