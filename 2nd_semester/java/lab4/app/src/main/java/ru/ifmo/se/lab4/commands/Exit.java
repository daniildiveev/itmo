package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.handler.CollectionHandler;

public class Exit implements Command{
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- exit application without saving\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        System.exit(0);
    }
}
