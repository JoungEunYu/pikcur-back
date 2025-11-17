package com.pikcurchu.pikcur.config;

import com.pikcurchu.pikcur.util.JwtFilter;
import com.pikcurchu.pikcur.util.OptionalJwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JwtFilterConfig {

    private final JwtFilter jwtFilter;
    private final OptionalJwtFilter optionalJwtFilter;

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration() {
        FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(jwtFilter);
        registration.addUrlPatterns(
                "/auth/members/delete-account",
                "/auth/members/password",
                "/mypage/profile",
                "/mypage/store",
                "/goods/*/report",
                "/goods/*/like",
                "/goods",
                "/brand/*/like",
                "/bid/*/**",
                "/question/*/**",
                "/review/*",
                "/transactions/*/**",
                "/mypage/address",
                "/mypage/address/*",
                "/mypage/account",
                "/mypage/account/*",
                "/mypage/blocked-stores",
                "/mypage/blocked-stores/*",
                "/store/follow/*",
                "/alarm"
        );
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<OptionalJwtFilter> optionalJwtFilterRegistration() {
        FilterRegistrationBean<OptionalJwtFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(optionalJwtFilter);
        registration.addUrlPatterns(
                "/goods/*",
                "/goods/categories/*",
                "/brand/*",
                "/brand/*/goods",
                "/search/recent",
                "/search/goods");
        registration.setOrder(2);
        return registration;
    }
}
