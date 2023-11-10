package com.java.laba_5_6_7.NewsSite.Services;

import com.java.laba_5_6_7.NewsSite.Models.WebsiteStat;
import com.java.laba_5_6_7.NewsSite.Repositories.WebsiteStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteStatService {

    @Autowired
    private WebsiteStatRepository websiteStatRepository;

    public WebsiteStat getStats() {
        return websiteStatRepository.findById(1L).orElse(new WebsiteStat());
    }

    public void incrementVisitCount() {
        WebsiteStat stats = getStats();
        stats.setVisitCount(stats.getVisitCount() + 1);
        websiteStatRepository.save(stats);
    }
}
