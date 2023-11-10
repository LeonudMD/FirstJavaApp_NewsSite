package com.java.laba_5_6_7.NewsSite.Controllers;


import com.java.laba_5_6_7.NewsSite.Models.NewsPost;
import com.java.laba_5_6_7.NewsSite.Models.WebsiteStat;
import com.java.laba_5_6_7.NewsSite.Repositories.NewsPostRepository;
import com.java.laba_5_6_7.NewsSite.Services.WebsiteStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_MODER')")
public class NewsController {
    @Autowired
    private com.java.laba_5_6_7.NewsSite.Services.WebsiteStatService WebsiteStatService;

    @Autowired
    private com.java.laba_5_6_7.NewsSite.Services.TimeService TimeService;

    @Autowired
    private NewsPostRepository NewsPostRepository;



    @PreAuthorize("hasAuthority('ROLE_MODER')")
    @GetMapping("/AddNews")
    public String AddNews(Model model){
        return "AddNews";
    }

    @PreAuthorize("hasAuthority('ROLE_MODER')")
    @GetMapping("/ModerPanel")
    public String ModerPanel(Model model) {
        Iterable<NewsPost> news = NewsPostRepository.findAll();
        model.addAttribute("news", news);

        WebsiteStatService.incrementVisitCount();

        WebsiteStat stats = WebsiteStatService.getStats();
        String currentTime = TimeService.getCurrentTime();
        model.addAttribute("currentTime", currentTime);
        model.addAttribute("visitCount", stats.getVisitCount());

        return "ModerPanel"; // Возвращаем страницу модератора
    }

    @PreAuthorize("hasAuthority('ROLE_MODER')")
    @PostMapping("/AddNews")
    public String newsPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text,
                             Model model){


        NewsPost post = new NewsPost(title, anons, full_text);
        NewsPostRepository.save(post);
        return "redirect:/ModerPanel";
    }




    @GetMapping("/news/{id}/edit")
    public String newsEdit(@PathVariable(value = "id") long id, Model model){
        if(!NewsPostRepository.existsById(id)){
            return "redirect:/news";
        }
        Optional<NewsPost> post = NewsPostRepository.findById(id);
        ArrayList<NewsPost> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "news-edit";
    }

    @PreAuthorize("hasAuthority('ROLE_MODER')")
    @PostMapping("/news/{id}/edit")
    public String newsPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title,@RequestParam String anons, @RequestParam String full_text, Model model){
        NewsPost post = NewsPostRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        NewsPostRepository.save(post);
        return "redirect:/ModerPanel";
    }

    @PreAuthorize("hasAuthority('ROLE_MODER')")
    @PostMapping("/news/{id}/remove")
    public String newsPostDelete(@PathVariable(value = "id") long id, Model model){
        NewsPost post = NewsPostRepository.findById(id).orElseThrow();
        NewsPostRepository.delete(post);
        return "redirect:/ModerPanel";
    }

}
