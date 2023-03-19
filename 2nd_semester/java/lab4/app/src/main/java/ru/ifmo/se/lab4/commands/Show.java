package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.PriorityQueue;

public class Show implements Command{
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- show all elements of collection in String representation\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        for(Route r: collection){
            IOHandler.println(r.toString());
            IOHandler.println("");
        }
    }
}
