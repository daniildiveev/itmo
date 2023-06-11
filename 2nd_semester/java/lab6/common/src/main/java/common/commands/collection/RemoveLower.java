package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class RemoveLower extends CommandWithElement {
    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return getName() + " {element}        -- remove all elements from collection that is lower than given";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        PriorityQueue<Route> updatedCollection = collection.stream()
                .filter(route -> this.route.compareTo(route) >= 0)
                .collect(Collectors.toCollection(PriorityQueue::new));

        collectionHandler.updateCollection(updatedCollection);
    }
}
