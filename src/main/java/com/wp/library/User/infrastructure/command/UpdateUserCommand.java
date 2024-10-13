package com.wp.library.User.infrastructure.command;

import com.wp.library.User.domain.contract.UpdateUserRequest;
import com.wp.library.User.domain.user.User;
import com.wp.library.User.infrastructure.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserCommand implements UserCommand {
    private final UserJpaRepository userJpaRepository;
    private final UpdateUserRequest updateUserRequest;

    @Override
    public void execute() {
        User user = userJpaRepository.findById(updateUserRequest.id())
                .orElseThrow();
        user.setName(updateUserRequest.username());
        userJpaRepository.save(user);
    }
}
