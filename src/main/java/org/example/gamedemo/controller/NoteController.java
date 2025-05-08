package org.example.gamedemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.dto.UserDTO;
import org.example.gamedemo.entity.Note;
import org.example.gamedemo.service.INoteService;
import org.example.gamedemo.utils.UserHolder;
import org.springframework.web.bind.annotation.*;
import org.example.gamedemo.utils.SystemConstants;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Resource
    INoteService noteService;



    @PostMapping
    public Result createNote(@RequestBody Note note) {
//        @RequestBody这个注解会自动映射，但是需要大小写严格对应
        return noteService.postNote(note);
    }
    // 增

    @PutMapping("/{id}")
    public Result updateNote(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id);
        return noteService.updateNote(note);
    }
//    改

    @DeleteMapping("/{id}")
    public Result deleteNote(@PathVariable Long id) {
        return noteService.deleteById(id);
    }
//    删



    @GetMapping
    public Result getAllNotes() {
        return noteService.queryAll();
    }
//    查所有

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
//    查指定
    @GetMapping("/of/me")
    public Result queryMyNote(@RequestParam(value = "current", defaultValue = "1") Integer current) {
        // 获取登录用户
        UserDTO user = UserHolder.getUser();
        // 根据用户查询
        Page<Note> page = noteService.query().eq("user_id", user.getId()).page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
//        SELECT * FROM tb_blog
//        WHERE user_id = ?
//        LIMIT #{offset}, #{pageSize}
        // 返回数据
        List<Note> records = page.getRecords();
        long pageSize = page.getSize();
        return Result.ok(records, pageSize);
    }
//      查自己

    @GetMapping("/of/user")
    public Result queryUserNote(@RequestParam(value = "current", defaultValue = "1") Integer current, Long userId) {

        // 根据用户查询
        Page<Note> page = noteService.query().eq("user_id", userId).page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
//        SELECT * FROM tb_blog
//        WHERE user_id = ?
//        LIMIT #{offset}, #{pageSize}
        // 返回数据
        List<Note> records = page.getRecords();
        long pageSize = page.getSize();
        return Result.ok(records, pageSize);
    }
//      根据用户ID分页查询

    @GetMapping("/of/follow")
    public Result queryNoteOfFollow(
            @RequestParam("lastId") Long max, @RequestParam(value = "offset", defaultValue = "0") Integer offset){
        return noteService.queryNoteOfFollow(max, offset);
    }
//      关注推送（滚动分页）

    @GetMapping("/of/hot")
    public Result queryBlogOfNote(
            @RequestParam("lastId") Long max, @RequestParam(value = "offset", defaultValue = "0") Integer offset){
        return noteService.queryNoteOfHot(max, offset);
    }
//      查热门
    @GetMapping("/of/game")
    public Result queryNoteOfGame(
            @RequestParam("lastId") Long max, @RequestParam(value = "offset", defaultValue = "0") Integer offset){
        return noteService.queryNoteOfGame(max, offset);
    }
//      查某个tag
    @GetMapping("/of/liked")
    public Result queryNoteOfLiked(
            @RequestParam("lastId") Long max, @RequestParam(value = "offset", defaultValue = "0") Integer offset){
        return noteService.queryNoteOfLiked(max, offset);
    }
//    查询已点赞的note
//这些应该都是一样的


//    点赞功能

}

