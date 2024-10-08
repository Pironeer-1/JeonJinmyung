package com.example.week3.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Pironeer Week3 API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "전진명",
                        email = "jmj00327@gmail.com"
                )
        )
)
@Configuration
public class OpenApiConfig {
}
