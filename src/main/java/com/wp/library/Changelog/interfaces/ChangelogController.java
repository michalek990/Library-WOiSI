package com.wp.library.Changelog.interfaces;

import com.wp.library.Changelog.domain.adapter.ChangelogAdapter;
import com.wp.library.Changelog.domain.contract.ChangelogResponse;
import com.wp.library.Changelog.domain.contract.resource.ChangelogResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class ChangelogController implements ChangelogResource {
    private final ChangelogAdapter changelogAdapter;

    @Override
    public ChangelogResponse getChangelog() {
        return changelogAdapter.getChangelog();
    }
}
