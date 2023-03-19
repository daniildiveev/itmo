package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;

import java.util.PriorityQueue;

public class Add implements Command{
    @Override
    public String getName(){
        return "add";
    }

    @Override
    public String getDescription(){
        return getName() + "                             -- add new element to collection\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args){
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        Route route = new Route();
        collection.add(route);

        collectionHandler.updateCollection(collection);
    }
}