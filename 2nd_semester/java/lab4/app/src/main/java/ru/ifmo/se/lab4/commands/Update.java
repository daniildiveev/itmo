package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.List;
import java.util.PriorityQueue;

public class Update implements CommandWithElement{
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
        PriorityQueue<Route> newCollection = new PriorityQueue<>();

        try{
            int targetId = Integer.parseInt(args[1]);

            for (Route r:collection){
                int id = r.getId();

                if (id != targetId){
                    newCollection.add(r);
                }
                else{
                    Route.removeId(id);
                    Route new_route = new Route(id);
                    newCollection.add(new_route);
                }
            }

            collectionHandler.updateCollection(newCollection);
        }
        catch (Exception e){
            IOHandler.println("Invalid id provided");
        }
    }

    @Override
    public void executeFromFile(CollectionHandler collectionHandler, String[] args) {
        String argsString = String.join(" ", args);
        List<String> routeArgs = parseRoute(argsString);
        validateArgs(routeArgs);

        PriorityQueue<Route> collection = collectionHandler.getCollection();
        PriorityQueue<Route> newCollection = new PriorityQueue<>();

        try{
            int targetId = Integer.parseInt(args[1]);

            for (Route r:collection){
                int id = r.getId();

                if (id != targetId){
                    newCollection.add(r);
                }
                else{
                    Route.removeId(id);
                    Route new_route = new Route(routeArgs, id);
                    newCollection.add(new_route);
                }
            }

            collectionHandler.updateCollection(newCollection);
        }
        catch (Exception e){
            IOHandler.println("Invalid id provided");
        }
    }
}
