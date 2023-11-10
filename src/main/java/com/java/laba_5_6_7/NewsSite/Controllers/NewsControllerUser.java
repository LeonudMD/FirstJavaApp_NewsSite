package com.java.laba_5_6_7.NewsSite.Controllers;

import com.java.laba_5_6_7.NewsSite.Models.NewsPost;
import com.java.laba_5_6_7.NewsSite.Models.WebsiteStat;
import com.java.laba_5_6_7.NewsSite.Repositories.NewsPostRepository;
import com.java.laba_5_6_7.NewsSite.Services.TimeService;
import com.java.laba_5_6_7.NewsSite.Services.WebsiteStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class NewsControllerUser {
    @Autowired
    private com.java.laba_5_6_7.NewsSite.Services.WebsiteStatService WebsiteStatService;

    @Autowired
    private com.java.laba_5_6_7.NewsSite.Services.TimeService TimeService;

    @Autowired
    private NewsPostRepository NewsPostRepository;

    @GetMapping("/news")
    public String News(Model model){
        Iterable<NewsPost> news = NewsPostRepository.findAll();
        model.addAttribute("news", news);

        WebsiteStatService.incrementVisitCount();

        WebsiteStat stats = WebsiteStatService.getStats();
        String currentTime = TimeService.getCurrentTime();
        model.addAttribute("currentTime", currentTime);
        model.addAttribute("visitCount", stats.getVisitCount());

        return "news";
    }

    @GetMapping("/news/{id}")
    public String newsDitails(@PathVariable(value = "id") long id, Model model){
        if(!NewsPostRepository.existsById(id)){
            return "redirect:/news";
        }

        Optional<NewsPost> post = NewsPostRepository.findById(id);
        if (post.isPresent()) {
            NewsPost newsPost = post.get();

            // Увеличиваем значение views на 1
            newsPost.setViews(newsPost.getViews() + 1);
            NewsPostRepository.save(newsPost); // сохраняем изменения в базу данных

            ArrayList<NewsPost> res = new ArrayList<>();
            res.add(newsPost);
            model.addAttribute("post", res);
        }

        WebsiteStatService.incrementVisitCount();

        WebsiteStat stats = WebsiteStatService.getStats();
        model.addAttribute("currentTime", LocalDateTime.now());
        model.addAttribute("visitCount", stats.getVisitCount());

        return "news-details-user";
    }
}
