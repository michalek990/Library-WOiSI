package com.wp.library.Changelog.infrastructure;

import com.wp.library.Changelog.domain.changelog.Changelog;
import com.wp.library.Changelog.domain.contract.ChangelogResponse;
import org.mapstruct.Mapper;

@Mapper
interface ChangelogMapper {

    ChangelogResponse toChangelogResponse(Changelog changelog);
}
