package com.wp.library.Book.infrastructure;

import com.wp.library.Book.domain.adapter.BookAdapter;
import com.wp.library.Book.infrastructure.jpa.BookJpaRepository;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BookConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "library.logging", name = "enabled", havingValue = "false")
    BookAdapter baseBookAdapter(@NonNull BookJpaRepository bookJpaRepository) {
        return new BookService(bookJpaRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "library.logging", name = "enabled", havingValue = "true")
    BookAdapter loggingBookAdapter(@NonNull BookJpaRepository bookJpaRepository) {
        return new BookServiceLoggingProxy(new BookService(bookJpaRepository));
    }
}
