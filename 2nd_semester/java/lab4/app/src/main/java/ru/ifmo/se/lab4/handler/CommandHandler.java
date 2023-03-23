package ru.ifmo.se.lab4.handler;

import ru.ifmo.se.lab4.commands.Command;

public class CommandHandler{
    public static void process(String rawInput, CollectionHandler collectionHandler){
        String[] args = rawInput.split("\\s+");
        String commandName = args[0].strip();

        if (commandName.equals("")){
            IOHandler.println("Command cannot be empty!");
            return;
        }

        Command command = PackageParser.getCommand("ru.ifmo.se.lab4.commands", commandName, "Command");

        if (command == null) {
            IOHandler.println("No such command: " + commandName);
        } else {
            command.execute(collectionHandler, args);
        }
    }
}