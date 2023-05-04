package common.handler;

import common.commands.Command;
import common.commands.CommandWithElement;
import common.exceptions.InvalidCommandNameException;
import common.entities.Route;

import java.util.Arrays;

public class CommandHandler{
    public static Command process(String rawInput) throws InvalidCommandNameException{
        String[] args = rawInput.split("\\s+");
        String commandName = args[0].trim();

        if (commandName.isEmpty()){
            throw new InvalidCommandNameException("command name cannot be empty!");
        }

        Command command = PackageParser.getCommand("common.commands",
                commandName, new String[]{"Command", "CommandWithElement"});

        if (command == null) {
            throw new InvalidCommandNameException("no such command: " + commandName);
        }

        if(command instanceof CommandWithElement){
            Route r = new Route();
            ((CommandWithElement) command).setRoute(r);
        }

        command.setArgs(Arrays.copyOfRange(args, 1, args.length));

        return command;
    }
}