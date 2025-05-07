package org.example.gamedemo.controller;

import org.example.gamedemo.dto.Result;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/award")
@RestController
public class AwardController {

    @PostMapping("/issue")
    public Result issueAward(@RequestParam Long userId, @RequestParam Long awardId) {
        return null;
    }

    @GetMapping("/list/{userId}")
    public Result getAwardList(@PathVariable Long userId) {
        return null;
    }

    @PostMapping("/claim")
    public Result claimAward(@RequestParam Long userId, @RequestParam Long awardId) {
        return null;
    }
}