package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.PriorityQueue;

public class Update implements Command{
    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return getName() + " id {element}             -- update collection element with respect to id\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        PriorityQueue<Route> new_collection = new PriorityQueue<>();

        try{
            int targetId = Integer.parseInt(args[1]);

            for (Route r:collection){
                int id = r.getId();

                if (id == targetId){
                    new_collection.add(r);
                }
                else{
                    Route new_route = new Route();
                    new_collection.add(new_route);
                }
            }

            collectionHandler.updateCollection(new_collection);
        }
        catch (Exception e){
            IOHandler.println("Invalid id provided");
        }
    }
}
