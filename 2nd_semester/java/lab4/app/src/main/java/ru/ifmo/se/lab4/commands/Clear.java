package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;

import java.util.PriorityQueue;

public class Clear implements Command{
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return getName() + "                           -- clear the whole collection\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args){
        collectionHandler.updateCollection(new PriorityQueue<Route>());
    }
}
