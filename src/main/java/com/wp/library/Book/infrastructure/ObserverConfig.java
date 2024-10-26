package com.wp.library.Book.infrastructure;


import com.wp.library.Book.domain.observer.EventPublisher;
import com.wp.library.Book.domain.observer.NotificationServiceObserver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObserverConfig {

    @Bean
    public EventPublisher eventPublisher(NotificationServiceObserver notificationServiceObserver) {
        EventPublisher eventPublisher = new EventPublisher();
        eventPublisher.addObserver(notificationServiceObserver);
        return eventPublisher;
    }
}
