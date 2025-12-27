package com.jws.boardapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")   // /api로 시작하는 모든 요청에 대해
      .allowedOrigins("http://localhost:3000") // Next.js 주소 허용
      .allowedMethods("GET", "POST", "PUT", "DELETE");
  }
}
