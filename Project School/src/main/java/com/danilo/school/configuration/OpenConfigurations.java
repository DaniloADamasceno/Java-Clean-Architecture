package com.danilo.school.configuration;

import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;

public class OpenConfigurations {

    @Bean
    public OpenAPI customOpenAPI() { // link para acessar o SWAGGER: http://localhost:8080/swagger-ui.html
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("Escola SOFTWAY ")
                                .version("1.0.0")
                                .description("Application for Escola SOFTWAY")
                );
    }
}
