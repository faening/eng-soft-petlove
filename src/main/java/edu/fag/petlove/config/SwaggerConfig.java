package edu.fag.petlove.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(
                new Info()
                    .title("PetLove API REST with Java 17 and Spring Boot 3")
                    .version("v1")
                    .description("A PetLove API é uma pequena e eficiente API REST baseada na landing page de produtos da Petz, um conhecido petshop online em todo o Brasil.")
                    .license(new License().name("MIT License"))
            );
    }
}
