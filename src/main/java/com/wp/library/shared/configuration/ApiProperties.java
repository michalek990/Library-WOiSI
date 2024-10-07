package com.wp.library.shared.configuration;

import jakarta.annotation.PostConstruct;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Component
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    @Builder.Default
    private String baseUrl = "localhost";

    @PostConstruct
    public void postConstruct(){
        log.info("Api properties: {}", this);
    }
}
