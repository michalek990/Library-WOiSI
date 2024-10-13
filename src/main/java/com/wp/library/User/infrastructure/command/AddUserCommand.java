package com.wp.library.User.infrastructure.command;

import com.wp.library.User.domain.contract.CreateUserRequest;
import com.wp.library.User.domain.user.User;
import com.wp.library.User.infrastructure.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddUserCommand implements UserCommand {
    private final UserJpaRepository userJpaRepository;
    private final CreateUserRequest createUserRequest;

    @Override
    public void execute() {
        User user = User.builder()
                .name(createUserRequest.name())
                .email(createUserRequest.email())
                .build();
        User newUser = userJpaRepository.save(user);
        System.out.println(newUser);
    }
}
