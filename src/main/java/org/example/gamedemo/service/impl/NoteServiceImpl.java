package org.example.gamedemo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.dto.ScrollResult;
import org.example.gamedemo.dto.UserDTO;
import org.example.gamedemo.entity.Follow;
import org.example.gamedemo.entity.Note;
import org.example.gamedemo.entity.User;
import org.example.gamedemo.mapper.NoteMapper;
import org.example.gamedemo.service.IFollowService;
import org.example.gamedemo.service.INoteService;
import org.example.gamedemo.service.IUserService;
import org.example.gamedemo.utils.UserHolder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.example.gamedemo.utils.RedisConstants.FEED_KEY;

@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {
    @Resource
    private RabbitTemplate rabbitTemplate;
    //暂时还不需要用到消息队列
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private IUserService userService;

    @Resource
    private IFollowService followService;
    @Override
    public Result queryNoteById(Long id) {
        Note note = getById(id);
        if(note == null){
            return Result.fail("cant find this note");
        }
        return Result.ok(note);
    }

    @Override
    public Result queryAll() {
        List<Note> notes = list();
        // 获取所有
        if(notes == null){
            return Result.fail("cant find any note");
        }
        return Result.ok(notes);
    }
    @Override
    public Result queryNoteOfFollow(Long max, Integer offset) {
        // 1.获取当前用户
        Long userId = UserHolder.getUser().getId();
        // 2.查询收件箱 ZREVRANGEBYSCORE key Max Min LIMIT offset count
        String key = FEED_KEY + userId;

        Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.opsForZSet()
                .reverseRangeByScoreWithScores(key, 0, max, offset, 2);
        // 3.非空判断
        if (typedTuples == null || typedTuples.isEmpty()) {
            return Result.ok();
        }
        // 4.解析数据：blogId、minTime（时间戳）、offset
        List<Long> ids = new ArrayList<>(typedTuples.size());
        long minTime = 0; // 2
        int os = 1; // 2
        for (ZSetOperations.TypedTuple<String> tuple : typedTuples) { // 5 4 4 2 2
            // 4.1.获取id
            ids.add(Long.valueOf(tuple.getValue()));
            // 4.2.获取分数(时间戳）
            long time = tuple.getScore().longValue();
            if(time == minTime){
                os++; // 相同时间戳递增偏移量
            }else{
                minTime = time; // 记录新时间戳
                os = 1; // 重置偏移量
            }
        }

        // 5.根据id查询Note
        String idStr = StrUtil.join(",", ids);
        List<Note> notes = query().in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list();

        // 附加用户和点赞信息
//        for (Note note : notes) {
//            // 5.1.查询blog有关的用户
//            queryBlogUser(note);
//            // 5.2.查询blog是否被点赞
//            isBlogLiked(note);
//        }

        // 6.封装并返回
        ScrollResult r = new ScrollResult();
        r.setList(notes);
        r.setOffset(os);
        r.setMinTime(minTime);

        return Result.ok(r);
    }

    @Override
    public Result queryNoteOfHot(Long max, Integer offset) {
        return null;
    }

    @Override
    public Result queryNoteOfGame(Long max, Integer offset) {
        return null;
    }

    @Override
    public Result queryNoteOfLiked(Long max, Integer offset) {
        return null;
    }

    @Override
    public Result postNote(Note note) {
////        在存储之前还需要把实体类填完整
//        note.setCreateTime(LocalDateTime.now());
//        note.setUpdateTime(LocalDateTime.now());
//        note.setLiked(0);
//        note.setComments(0);
//        if(!save(note)){
//            return Result.fail("save not fail");
//        }
//        return Result.ok();
        // 1.获取登录用户
        UserDTO user = UserHolder.getUser();
        note.setUserId(user.getId());
        // 2.保存探店笔记
        boolean isSuccess = save(note);
        if(!isSuccess){
            return Result.fail("fail to save note");
        }
        // 3.查询笔记作者的所有粉丝 select * from tb_follow where follow_user_id = ?
        List<Follow> follows = followService.query().eq("follow_user_id", user.getId()).list();
        // 4.推送笔记id给所有粉丝
        for (Follow follow : follows) {
            // 4.1.获取粉丝id
            Long userId = follow.getUserId();
            // 4.2.推送
            String key = FEED_KEY + userId;
            stringRedisTemplate.opsForZSet().add(key, note.getId().toString(), System.currentTimeMillis());
        }
        // 5.返回id
        return Result.ok(note.getId());
    }

    @Override
    public Result updateNote(Note note) {
        if(updateById(note)){
            return Result.ok();
        }
        return Result.fail("fail to update");
    }

    @Override
    public Result deleteById(Long id) {
        if (id == null) {
            return Result.fail("id cant be null");
        }
        boolean success = removeById(id);
        return success ? Result.ok() : Result.fail("fail to delete");
    }

    private void queryBlogUser(Note note) {
        Long userId = note.getUserId();
        User user = userService.getById(userId);
        note.setName(user.getNickName());
        note.setIcon(user.getIcon());
    }
}
