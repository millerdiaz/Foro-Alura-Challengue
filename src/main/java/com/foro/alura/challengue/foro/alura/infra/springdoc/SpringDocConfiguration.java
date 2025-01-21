package com.foro.alura.challengue.foro.alura.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))

                .info(new Info()
                        .title("Alura Foro Challengue")
                        .description("API REST diseñada para gestionar de manera eficiente usuarios, tópicos, respuestas, perfiles y cursos dentro de un foro. Implementa un sistema de autenticación robusto utilizando tokens JWT para garantizar la seguridad en el acceso y las operaciones.")
                        .contact(new Contact()
                                .name("Miller Peña")
                                .email("millerpena11@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0\n"))
                )
                ;
    }
}
