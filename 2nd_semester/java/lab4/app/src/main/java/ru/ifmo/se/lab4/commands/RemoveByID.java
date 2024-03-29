package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.PriorityQueue;

public class RemoveByID implements Command{
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return getName() + " id                 -- remove element with respect to id\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        PriorityQueue<Route> newCollection = new PriorityQueue<>();

        try{
            int targetId = Integer.parseInt(args[1]);

            for (Route r:collection){
                int id = r.getId();

                if (id != targetId){
                    newCollection.add(r);
                }
                else {
                    Route.removeId(id);
                }
            }

            collectionHandler.updateCollection(newCollection);
        }
        catch (Exception e){
            IOHandler.println("Invalid id provided");
        }
    }
}
