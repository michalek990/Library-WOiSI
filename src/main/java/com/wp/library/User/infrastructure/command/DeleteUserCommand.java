package com.wp.library.User.infrastructure.command;

import com.wp.library.User.infrastructure.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteUserCommand implements UserCommand {
    private final UserJpaRepository userJpaRepository;
    private final Long userId;

    @Override
    public void execute() {
        userJpaRepository.deleteById(userId);
    }
}
