package com.wp.library.shared.configuration;

import jakarta.validation.ClockProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ClockProviderConfiguration {

    @Bean
    @ConditionalOnMissingBean(ClockProvider.class)
    public ClockProvider getClockProvider(){
        return Clock::systemUTC;
    }
}
