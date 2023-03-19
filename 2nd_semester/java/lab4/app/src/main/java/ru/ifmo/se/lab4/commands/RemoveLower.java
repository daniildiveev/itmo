package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;

import java.util.PriorityQueue;

public class RemoveLower implements Command{
    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return getName() + " {element}        -- remove all elements from collection that is greater than given\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        PriorityQueue<Route> new_collection = new PriorityQueue<>();

        Route routeToCompare = new Route();

        for (Route r: collection){
            if (r.compareTo(routeToCompare) < 0){
                new_collection.add(r);
            }
        }

        collectionHandler.updateCollection(new_collection);
    }
}