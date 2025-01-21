package com.foro.alura.challengue.foro.alura.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class  CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Acceder a todas las rutas
                        .allowedOrigins("http://127.0.0.1:5500") // Punto de origrn permitido
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Todo los métodos que estan permitidos
                        .allowedHeaders("*"); // acceder a todos los encabezados
            }
        };
    }
}
