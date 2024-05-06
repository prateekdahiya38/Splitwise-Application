package com.project.splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class CommandRegistry {
    private List<Command> commands;

    @Autowired
    public CommandRegistry(RegisterUserCommand registerUserCommand,
                           UpdateProfileCommand updateProfileCommand,
                           AddGroupCommand addGroupCommand) {
        commands = new ArrayList<>();
        commands.add(registerUserCommand);
        commands.add(updateProfileCommand);
        commands.add(addGroupCommand);
    }

    public void execute(String input){
        for (Command command : commands){
            if (command.macthes(input)){
                command.execute(input);
                break;
            }
        }
    }
}
