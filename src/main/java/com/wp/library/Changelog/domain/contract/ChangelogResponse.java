package com.wp.library.Changelog.domain.contract;

import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ChangelogResponse {
    String apiName;
    String apiVersion;
    List<ChangelogLogResponse> logs;
}
