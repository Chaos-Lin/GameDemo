package org.example.gamedemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Follow;

public interface IFollowService extends IService<Follow> {

    Result follow(Long followUserId, Boolean isFollow);

    Result isFollow(Long followUserId);

    Result followCommons(Long id);
}
