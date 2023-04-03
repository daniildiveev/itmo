package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.List;
import java.util.PriorityQueue;

public class RemoveGreater implements CommandWithElement{
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
        PriorityQueue<Route> newCollection = new PriorityQueue<>();

        Route routeToCompare = new Route();

        for (Route r: collection){
            if (r.compareTo(routeToCompare) > 0){
                newCollection.add(r);
            }
            else {
                Route.removeId(r.getId());
            }
        }

        collectionHandler.updateCollection(newCollection);
    }

    @Override
    public void executeFromFile(CollectionHandler collectionHandler, String[] args) {
        String argsString = String.join(" ", args);
        List<String> routeArgs = parseRoute(argsString);
        validateArgs(routeArgs);

        PriorityQueue<Route> collection = collectionHandler.getCollection();
        PriorityQueue<Route> newCollection = new PriorityQueue<>();

        try{
            Route routeToCompare = new Route(routeArgs,-1);

            for (Route r: collection){
                if (r.compareTo(routeToCompare) > 0){
                    newCollection.add(r);
                }
                else {
                    Route.removeId(r.getId());
                }
            }
        }
        catch (Exception e){
            IOHandler.println(e.getMessage());
        }

        collectionHandler.updateCollection(newCollection);
    }
}
