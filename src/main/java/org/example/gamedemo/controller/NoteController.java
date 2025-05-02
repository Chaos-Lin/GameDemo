package org.example.gamedemo.controller;

import org.example.gamedemo.dto.Result;
import org.example.gamedemo.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Resource
    INoteService noteService;

    //note/1
//    @GetMapping("/{id}")
//    public Result queryById(@PathVariable("id") Long id){
//        //return Result.ok();
//        return noteService.queryNoteById(id);
//
//    }

    //note?id=1 形式的请求了
    @GetMapping
    public Result queryById(@RequestParam("id") Long id) {
        return noteService.queryNoteById(id);
    }
}
