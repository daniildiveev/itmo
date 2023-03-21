package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.PriorityQueue;

public class RemoveAnyByDistance implements Command{
    @Override
    public String getName() {
        return "remove_any_by_distance";
    }

    @Override
    public String getDescription() {
        return getName() + " distance -- remove any element from collection which distance is equal to the given\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        PriorityQueue<Route> new_collection = new PriorityQueue<>();

        try{
            long targetDistance = Long.parseLong(args[1]);
            boolean elementRemoved = false;

            for (Route r:collection){
                long distance = r.getDistance();

                if (targetDistance != distance | elementRemoved){
                    new_collection.add(r);
                }
                else{
                    elementRemoved = true;
                }
            }

            collectionHandler.updateCollection(new_collection);
        }
        catch (Exception e){
            IOHandler.println("Invalid distance provided");
        }
    }
}
