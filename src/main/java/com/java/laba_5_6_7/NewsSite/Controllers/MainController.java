package com.java.laba_5_6_7.NewsSite.Controllers;

import com.java.laba_5_6_7.NewsSite.Models.WebsiteStat;
import com.java.laba_5_6_7.NewsSite.Services.UserService;
import com.java.laba_5_6_7.NewsSite.Services.WebsiteStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.time.LocalDateTime;


@Controller
public class MainController {

    private final UserService userService;
    @Autowired
    private WebsiteStatService WebsiteStatService;

    @Autowired
    public MainController(UserService userService, WebsiteStatService websiteStatService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        model.addAttribute("title", "Fresh Insides");
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        WebsiteStatService.incrementVisitCount();

        WebsiteStat stats = WebsiteStatService.getStats();
        model.addAttribute("currentTime", LocalDateTime.now());
        model.addAttribute("visitCount", stats.getVisitCount());
        return "home";
    }
    

}