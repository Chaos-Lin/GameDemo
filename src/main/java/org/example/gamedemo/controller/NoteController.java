package org.example.gamedemo.controller;

import org.example.gamedemo.dto.Result;
import org.example.gamedemo.entity.Note;
import org.example.gamedemo.service.INoteService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Resource
    INoteService noteService;


    @GetMapping
    public Result getAllNotes() {
        return noteService.queryAll();
    }

    //note?id=1 形式的请求了
//    @GetMapping
//    public Result queryById(@RequestParam("id") Long id) {
//        return noteService.queryNoteById(id);
//    }

    //note/1
    @GetMapping("/{id}")
    public Result queryById(@PathVariable("id") Long id){
        //return Result.ok();
        return noteService.queryNoteById(id);

    }
    @PostMapping
    public Result createNote(@RequestBody Note note) {
//        @RequestBody这个注解会自动映射，但是需要大小写严格对应
        return noteService.postNote(note);
    }

    @PutMapping("/{id}")
    public Result updateNote(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id);
        return noteService.updateNote(note);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        return noteService.deleteById(id);
    }
}
