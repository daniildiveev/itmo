package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class Add implements CommandWithElement{
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

    @Override
    public void executeFromFile(CollectionHandler collectionHandler, String[] args) {
        String argsString = String.join(" ", args);
        List<String> routeArgs = parseRoute(argsString);
        validateArgs(routeArgs);

        PriorityQueue<Route> collection = collectionHandler.getCollection();

        try{
            Route r = new Route(routeArgs, -1);
            collection.add(r);
            collectionHandler.updateCollection(collection);
        } catch (Exception e){
            IOHandler.println(e.getMessage());
        }
    }
}