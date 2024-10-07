package com.wp.library.shared.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    private static final String SCHEMA_NAME = "bearerAuth";
    private static final String SCHEME = "bearer";

    @Value("${app.name}")
    public String appTitle;

    @Value("${app.description}")
    public String appDescription;

    @Value("${app.version}")
    public String appVersion;

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title(appTitle)
                        .description(appDescription)
                        .version(appVersion))
                .components(new Components()
                        .addSecuritySchemes(SCHEMA_NAME, createSecurityScheme()))
                .addSecurityItem(new SecurityRequirement().addList(SCHEMA_NAME));
    }

    private SecurityScheme createSecurityScheme(){
        return new SecurityScheme()
                .name(SCHEMA_NAME)
                .type(SecurityScheme.Type.HTTP)
                .scheme(SCHEME);
    }
}
