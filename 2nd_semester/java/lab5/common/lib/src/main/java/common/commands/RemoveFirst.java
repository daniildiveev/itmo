package common.commands;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class RemoveFirst extends Command{
    @Override
    public String getName() {
        return "remove_first";
    }

    @Override
    public String getDescription() {
        return getName() + "                    -- remove first element from collection\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        collection.stream()
                .findFirst()
                .ifPresent(collection::remove);
    }
}
