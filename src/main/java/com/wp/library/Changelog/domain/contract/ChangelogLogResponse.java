package com.wp.library.Changelog.domain.contract;

import lombok.Builder;

@Builder
public record ChangelogLogResponse(
        String version,
        String author,
        String date,
        String log
) {}
