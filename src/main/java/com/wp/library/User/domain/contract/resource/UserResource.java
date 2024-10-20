package com.wp.library.User.domain.contract.resource;

import com.wp.library.User.domain.contract.CreateUserRequest;
import com.wp.library.User.domain.contract.UpdateUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserResource {
    String USER_URL = "/users";
    String USER_DELETE_URL = "/users/{userId}";

    String JSON = MediaType.APPLICATION_JSON_VALUE;

    @PostMapping(USER_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successful creating new user"),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentication failed",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<Void> createUser(@Valid CreateUserRequest request);

    @PatchMapping(USER_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successful patch user"),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentication failed",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<Void> updateUser(@Valid UpdateUserRequest request);

    @DeleteMapping(USER_DELETE_URL)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successful delete user"),
            @ApiResponse(
                    responseCode = "401",
                    description = "Authentication failed",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = JSON, schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);
}
