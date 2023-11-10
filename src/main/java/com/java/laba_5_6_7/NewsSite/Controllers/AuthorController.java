package com.java.laba_5_6_7.NewsSite.Controllers;

import com.java.laba_5_6_7.NewsSite.Models.WebsiteStat;
import com.java.laba_5_6_7.NewsSite.Services.WebsiteStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class AuthorController {
    @Autowired
    private WebsiteStatService WebsiteStatService;
    @GetMapping("/authors")
    public String Authors(Model model){
        WebsiteStat stats = WebsiteStatService.getStats();
        model.addAttribute("currentTime", LocalDateTime.now());
        model.addAttribute("visitCount", stats.getVisitCount());
        return "authors";
    }
}