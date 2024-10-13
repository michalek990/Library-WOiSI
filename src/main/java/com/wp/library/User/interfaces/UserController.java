package com.wp.library.User.interfaces;

import com.wp.library.User.domain.contract.CreateUserRequest;
import com.wp.library.User.domain.contract.UpdateUserRequest;
import com.wp.library.User.domain.contract.resource.UserResource;
import com.wp.library.User.infrastructure.command.AddUserCommand;
import com.wp.library.User.infrastructure.command.CommandManager;
import com.wp.library.User.infrastructure.command.DeleteUserCommand;
import com.wp.library.User.infrastructure.command.UpdateUserCommand;
import com.wp.library.User.infrastructure.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserResource {
    private final CommandManager commandManager;
    private final UserJpaRepository userJpaRepository;

    @Override
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request) {
        commandManager.execute(new AddUserCommand(userJpaRepository, request));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> updateUser(@RequestBody UpdateUserRequest request) {
        commandManager.execute(new UpdateUserCommand(userJpaRepository, request));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        commandManager.execute(new DeleteUserCommand(userJpaRepository, userId));
        return ResponseEntity.noContent().build();
    }
}
