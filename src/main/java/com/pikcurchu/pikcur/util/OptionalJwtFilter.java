package com.pikcurchu.pikcur.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class OptionalJwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                if (JwtUtil.validateToken(token)) {
                    Integer memberNo = JwtUtil.getMemberNo(token);
                    request.setAttribute("memberNo", memberNo);
                }
            } catch (Exception ignored) {
                // 토큰이 잘못되었더라도 그냥 통과시킴
            }
        }

        filterChain.doFilter(request, response);
    }
}
