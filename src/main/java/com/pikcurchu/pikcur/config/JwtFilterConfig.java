package com.pikcurchu.pikcur.config;

import com.pikcurchu.pikcur.util.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfig {

    private final JwtFilter jwtFilter;

    public JwtFilterConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration() {
        FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(jwtFilter);
        registration.addUrlPatterns(
                "/auth/members/delete-account",
                "/auth/members/password",
                "/mypage/profile"
        );
        registration.setOrder(1);
        return registration;
    }
}
