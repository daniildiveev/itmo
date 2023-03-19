package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

public class Info implements Command{
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- show information about collection (type, initialization date, number of elements)\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        String info = collectionHandler.info();

        IOHandler.println(info);
    }
}
