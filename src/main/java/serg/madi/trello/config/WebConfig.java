package serg.madi.trello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Разрешаем запросы с фронтенда (например, на localhost:3000)
        registry.addMapping("/api/**")  // Разрешить все запросы на пути /api/*
                .allowedOrigins("*")  // Разрешаем только с этого источника
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Разрешаем только эти методы
                .allowedHeaders("*");  // Разрешаем все заголовки
    }
}
