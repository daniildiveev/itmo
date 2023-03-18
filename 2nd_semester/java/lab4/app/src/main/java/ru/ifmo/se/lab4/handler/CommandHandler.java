package ru.ifmo.se.lab4.handler;

import ru.ifmo.se.lab4.commands.Command;

public class CommandHandler{
    public static void process(String rawInput){
        String[] args = rawInput.split("\\s+");
        String commandName = args[0].strip();

        if (commandName.equals("exit")) {
            System.exit(1);
        }

        Command command = PackageParser.getCommand("ru.ifmo.se.lab4.commands", commandName, "Command");

        if (command == null){
            IOHandler.println("No such command: " + commandName);
        }

        else {
            //TODO: implement command execution (CollectionHandler needed)
        }
    }
}