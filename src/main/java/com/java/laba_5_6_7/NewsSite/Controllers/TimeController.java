package com.java.laba_5_6_7.NewsSite.Controllers;

import com.java.laba_5_6_7.NewsSite.Services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public String getCurrentTime() {
        return timeService.getCurrentTime();
    }
}