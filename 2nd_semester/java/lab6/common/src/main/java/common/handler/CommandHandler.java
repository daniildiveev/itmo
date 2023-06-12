package common.handler;

import common.commands.Command;
import common.commands.collection.CollectionCommand;
import common.exceptions.InvalidCommandNameException;

import java.util.Arrays;

public class CommandHandler{
    public static Command process(String rawInput) throws InvalidCommandNameException{
        String[] args = rawInput.split("\\s+");
        String commandName = args[0].trim();

        if (commandName.isEmpty()){
            throw new InvalidCommandNameException("command name cannot be empty!");
        }

        Command command = PackageParser.getCommand("common.commands.collection",
                commandName, new String[]{"CollectionCommand", "CommandWithElement"});

        if(command == null){
            command = PackageParser.getCommand("common.commands.authentication",
                    commandName, new String[]{"AuthenticationCommand"});
        } else {
            CollectionCommand collectionCommand = (CollectionCommand) command;
            collectionCommand.setArgs(Arrays.copyOfRange(args, 1, args.length));

            return collectionCommand;
        }

        if (command == null) {
            throw new InvalidCommandNameException("no such command: " + commandName);
        }

        return null;
    }
}