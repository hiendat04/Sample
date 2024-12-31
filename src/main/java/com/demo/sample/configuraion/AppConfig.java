package com.demo.sample.configuraion;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AppConfig extends OncePerRequestFilter {
    // Filter all request to the app FIRST. If the request is allowed, then they can
    // use the API
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Further config different header such as :
        // Access-Control-Allowed-Header,
        // Access-Control-Allowed-Method
        response.setHeader("Access-Control-Allowed-Origin", "http://localhost:5173");
        filterChain.doFilter(request, response);
    }

}
