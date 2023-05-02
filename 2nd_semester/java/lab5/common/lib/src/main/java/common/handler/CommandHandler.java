package common.handler;

import common.commands.Command;
import common.exceptions.InvalidCommandNameException;

public class CommandHandler{
    public static Command process(String rawInput, CollectionHandler collectionHandler) throws InvalidCommandNameException{
        String[] args = rawInput.split("\\s+");
        String commandName = args[0].trim();

        if (commandName.isEmpty()){
            throw new InvalidCommandNameException("command name cannot be empty!");
        }

        Command command = PackageParser.getCommand("common.commands",
                commandName, new String[]{"Command", "CommandWithElement"});

        if (command == null) {
            throw new InvalidCommandNameException("no such command" + commandName);
        }

        return command;
    }
}