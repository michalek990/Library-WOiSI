package com.wp.library.Changelog.domain.changelog;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter(AccessLevel.PACKAGE)
@Getter
public class Changelog {
    private static final Resource CHANGELOG = new ClassPathResource("changelog.json");

    private static final Changelog EAGER_SINGLETON = parseFromJson();

    private static Changelog SINGLETON;

    private String apiName;
    private String apiVersion;
    private List<ChangelogLog> logs;

    public static Changelog getEagerSingleton() {
        return EAGER_SINGLETON;
    }

    public static Changelog getDoubleCheckLockSingleton() {
        if (SINGLETON == null) {
            synchronized (Changelog.class) {
                if (SINGLETON == null) {
                    SINGLETON = parseFromJson();
                }
            }
        }
        return SINGLETON;
    }

    public static Changelog getBillPughSingleton() {
        return BillPughSingleton.SINGLETON;
    }

    private static class BillPughSingleton {
        private static final Changelog SINGLETON = parseFromJson();
    }

    @SneakyThrows
    private static Changelog parseFromJson() {
        String json = new String(CHANGELOG.getInputStream().readAllBytes());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Changelog.class);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Setter(AccessLevel.PACKAGE)
    @Getter
    public static class ChangelogLog {
        private String version;
        private String author;
        private String date;
        private String log;
    }
}
