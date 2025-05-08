package org.example.gamedemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Note;
import org.springframework.stereotype.Service;

//@Service
//注解一般加在实现类上面，这样就会自动注入了
public interface INoteService extends IService<Note> {
//    因为继承了IService接口就可以直接使用一些增删改查的函数
    Result queryNoteById(Long id);
//    在接口（interface)中，所有方法的默认修饰符就是 public abstract
    Result queryAll();

    Result postNote(Note note);

    Result updateNote(Note note);

    Result deleteById(Long id);

    Result queryNoteOfFollow(Long max, Integer offset);

    Result queryNoteOfHot(Long max, Integer offset);

    Result queryNoteOfGame(Long max, Integer offset);

    Result queryNoteOfLiked(Long max, Integer offset);
}
