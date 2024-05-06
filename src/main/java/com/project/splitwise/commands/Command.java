package com.project.splitwise.commands;

public interface Command {
    boolean macthes(String input);

    void execute(String input);
}
