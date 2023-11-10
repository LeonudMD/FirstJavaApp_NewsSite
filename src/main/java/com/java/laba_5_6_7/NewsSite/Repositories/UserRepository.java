package com.java.laba_5_6_7.NewsSite.Repositories;

import com.java.laba_5_6_7.NewsSite.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
