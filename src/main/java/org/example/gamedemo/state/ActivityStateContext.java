package org.example.gamedemo.state;

import org.example.gamedemo.entity.Activity;
import org.example.gamedemo.mapper.ActivityMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class ActivityStateContext {

    @Resource
    private ActivityMapper activityMapper;

    private final Map<Integer, AbstractState> stateMap = new HashMap<>();

    public ActivityStateContext() {
        // 初始化状态映射，这里需要根据实际情况添加更多状态
        stateMap.put(0, new EditingState()); 
    }

    public boolean arraignment(Long activityId, Integer currentStatus) {
        AbstractState state = stateMap.get(currentStatus);
        if (state != null) {
            return state.arraignment(activityId, currentStatus);
        }
        return false;
    }

    public boolean checkPass(Long activityId, Integer currentStatus) {
        AbstractState state = stateMap.get(currentStatus);
        if (state != null) {
            return state.checkPass(activityId, currentStatus);
        }
        return false;
    }

    public boolean checkRefuse(Long activityId, Integer currentStatus) {
        AbstractState state = stateMap.get(currentStatus);
        if (state != null) {
            return state.checkRefuse(activityId, currentStatus);
        }
        return false;
    }

    public boolean checkRevoke(Long activityId, Integer currentStatus) {
        AbstractState state = stateMap.get(currentStatus);
        if (state != null) {
            return state.checkRevoke(activityId, currentStatus);
        }
        return false;
    }

    public boolean close(Long activityId, Integer currentStatus) {
        AbstractState state = stateMap.get(currentStatus);
        if (state != null) {
            return state.close(activityId, currentStatus);
        }
        return false;
    }

    public boolean open(Long activityId, Integer currentStatus) {
        AbstractState state = stateMap.get(currentStatus);
        if (state != null) {
            return state.open(activityId, currentStatus);
        }
        return false;
    }

    public boolean doing(Long activityId, Integer currentStatus) {
        AbstractState state = stateMap.get(currentStatus);
        if (state != null) {
            return state.doing(activityId, currentStatus);
        }
        return false;
    }
}