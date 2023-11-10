package com.java.laba_5_6_7.NewsSite.Repositories;

import com.java.laba_5_6_7.NewsSite.Models.NewsPost;
import org.springframework.data.repository.CrudRepository;

public interface NewsPostRepository extends CrudRepository<NewsPost, Long> {
}
