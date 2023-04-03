package ru.ifmo.se.lab4.handler;

import ru.ifmo.se.lab4.commands.Command;
import ru.ifmo.se.lab4.commands.CommandWithElement;

public class CommandHandler{
    public static void process(String rawInput, CollectionHandler collectionHandler, boolean fromFile){
        String[] args = rawInput.split("\\s+");
        String commandName = args[0].strip();

        if (commandName.isEmpty()){
            IOHandler.println("Command cannot be empty!");
            return;
        }

        Command command = PackageParser.getCommand("ru.ifmo.se.lab4.commands",
                                                   commandName, new String[]{"Command", "CommandWithElement"});

        if (command == null) {
            IOHandler.println("No such command: " + commandName);
        }

        else if(fromFile & command instanceof CommandWithElement){
            CommandWithElement commandWithElement = (CommandWithElement) command;
            commandWithElement.executeFromFile(collectionHandler, args);
        }

        else {
            command.execute(collectionHandler, args);
        }
    }
}