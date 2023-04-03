package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;

import java.util.PriorityQueue;

public class RemoveFirst implements Command{
    @Override
    public String getName() {
        return "remove_first";
    }

    @Override
    public String getDescription() {
        return getName() + "                    -- remove first element from collection\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        PriorityQueue<Route> newCollection = new PriorityQueue<>();
        int i = 0;

        for (Route r: collection){
            if (i != 0){
                newCollection.add(r);
            }
            else {
                Route.removeId(r.getId());
            }

            i++;
        }

        collectionHandler.updateCollection(newCollection);
    }
}
