package com.wp.library.User.infrastructure.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandManager {
    private List<UserCommand> commandHistory = new ArrayList<>();

    public void execute(UserCommand command) {
        command.execute();
        commandHistory.add(command);
    }
}
