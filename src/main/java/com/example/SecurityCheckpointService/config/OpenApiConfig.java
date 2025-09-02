package com.example.SecurityCheckpointService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API du Service de Points de Contrôle de Sécurite")
                        .version("1.0")
                        .description("API pour gérer les journaux des points de contrôle de sécurite"));
    }
}
