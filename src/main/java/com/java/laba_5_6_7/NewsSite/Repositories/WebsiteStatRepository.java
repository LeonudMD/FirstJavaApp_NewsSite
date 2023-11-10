package com.java.laba_5_6_7.NewsSite.Repositories;

import com.java.laba_5_6_7.NewsSite.Models.WebsiteStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteStatRepository extends JpaRepository<WebsiteStat, Long> {}