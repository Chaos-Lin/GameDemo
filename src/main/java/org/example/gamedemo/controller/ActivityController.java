package org.example.gamedemo.controller;

import org.example.gamedemo.dto.Result;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/activity")
@RestController
public class ActivityController {

    @GetMapping("/list")
    public Result getActivityList() {
        return null;
    }

    @GetMapping("/detail/{activityId}")
    public Result getActivityDetail(@PathVariable Long activityId) {
        return null;
    }

    @PostMapping("/create")
    public Result createActivity() {
        return null;
    }

    @PostMapping("/update")
    public Result updateActivity() {
        return null;
    }

    @PostMapping("/delete/{activityId}")
    public Result deleteActivity(@PathVariable Long activityId) {
        return null;
    }
}