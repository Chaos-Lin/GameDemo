package org.example.gamedemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Note;
import org.example.gamedemo.mapper.NoteMapper;
import org.example.gamedemo.service.INoteService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {
    @Resource
    private RabbitTemplate rabbitTemplate;
    //暂时还不需要用到消息队列
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
    public Result postNote(Note note) {
//        在存储之前还需要把实体类填完整
        note.setCreateTime(LocalDateTime.now());
        note.setUpdateTime(LocalDateTime.now());
        note.setLiked(0);
        note.setComments(0);
        if(!save(note)){
            return Result.fail("save not fail");
        }
//        // 2.发送消息到队列（异步处理后续操作）
//        rabbitTemplate.convertAndSend(
//                "blogExchange",
//                "blog.publish",
//                note.getId()
//        );

        return Result.ok();
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
}
