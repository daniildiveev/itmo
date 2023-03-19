package ru.ifmo.se.lab4.handler;

import ru.ifmo.se.lab4.commands.Command;
import ru.ifmo.se.lab4.entities.Route;

import java.util.PriorityQueue;

public class CommandHandler{
    public static void process(String rawInput, CollectionHandler collectionHandler){
        String[] args = rawInput.split("\\s+");
        String commandName = args[0].strip();

        if (commandName.equals("exit")) {
            System.exit(0);
        }

        else if (commandName.equals("info")){
            IOHandler.println(collectionHandler.info());
        }

        else {
            Command command = PackageParser.getCommand("ru.ifmo.se.lab4.commands", commandName, "Command");

            if (command == null) {
                IOHandler.println("No such command: " + commandName);
            } else {
                command.execute(collectionHandler, args);
            }
        }
    }
}