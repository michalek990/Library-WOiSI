package com.wp.library.Changelog.domain.contract.resource;

import com.wp.library.Changelog.domain.contract.ChangelogResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface ChangelogResource {
    String CHANGELOG_URL = "/changelog";

    String JSON = MediaType.APPLICATION_JSON_VALUE;

    @GetMapping(CHANGELOG_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get changelog")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfuly fetched changelog",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ChangelogResponse.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentication failed",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
    })
    ChangelogResponse getChangelog();
}
