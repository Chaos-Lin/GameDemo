package org.example.gamedemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Follow;
import org.example.gamedemo.mapper.FollowMapper;
import org.example.gamedemo.service.IFollowService;

public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {
    @Override
    public Result follow(Long followUserId, Boolean isFollow) {
        return null;
    }

    @Override
    public Result isFollow(Long followUserId) {
        return null;
    }

    @Override
    public Result followCommons(Long id) {
        return null;
    }
}
