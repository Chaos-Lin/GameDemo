package org.example.gamedemo.controller;

import org.example.gamedemo.dto.Result;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/lottery")
@RestController
public class LotteryController {

    @GetMapping("/start")
    public Result startLottery() {
        return null;
    }

    @PostMapping("/participate")
    public Result participateLottery() {
        return null;
    }

    @GetMapping("/result/{userId}")
    public Result getLotteryResult(@PathVariable Long userId) {
        return null;
    }
}