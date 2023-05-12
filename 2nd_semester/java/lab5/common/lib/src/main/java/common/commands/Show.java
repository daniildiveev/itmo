package common.commands;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Show extends Command {
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- show all elements of collection in String representation\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        if (collection.isEmpty()){
            output.println("Collection is empty!");
        } else {
            collection.forEach(route -> output.println(route.toString()));
        }
    }
}

