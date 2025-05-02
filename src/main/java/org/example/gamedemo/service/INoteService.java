package org.example.gamedemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Note;
import org.springframework.stereotype.Service;

//@Service
//注解一般加在实现类上面，这样就会自动注入了
public interface INoteService extends IService<Note> {
//    因为继承了IService接口就可以直接使用一些增删改查的函数
    public Result queryNoteById(Long id);
}
