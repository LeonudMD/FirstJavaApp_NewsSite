package com.java.laba_5_6_7.NewsSite.Models.Enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_MODER, ROLE_ADMIN;
    @Override
    public String getAuthority() {
        return name();
    }
}
