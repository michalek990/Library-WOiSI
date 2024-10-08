package com.wp.library.Changelog.infrastructure;

import com.wp.library.Changelog.domain.adapter.ChangelogAdapter;
import com.wp.library.Changelog.domain.changelog.Changelog;
import com.wp.library.Changelog.domain.contract.ChangelogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ChangelogService implements ChangelogAdapter {
    private final ChangelogMapper changelogMapper;

    @Override
    public ChangelogResponse getChangelog() {
        Changelog changelog = Changelog.getBillPughSingleton();
        return changelogMapper.toChangelogResponse(changelog);
    }
}
