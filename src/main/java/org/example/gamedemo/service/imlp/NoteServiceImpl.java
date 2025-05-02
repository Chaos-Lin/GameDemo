package org.example.gamedemo.service.imlp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Note;
import org.example.gamedemo.mapper.NoteMapper;
import org.example.gamedemo.service.INoteService;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {
    @Override
    public Result queryNoteById(Long id) {
        Note note = getById(id);
        if(note == null){
            return Result.fail("cant find this note");
        }
        return Result.ok(note);
    }
}
