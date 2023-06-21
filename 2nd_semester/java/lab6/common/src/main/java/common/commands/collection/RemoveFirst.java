package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.PriorityQueue;

public class RemoveFirst extends CommandWithUser {
    @Override
    public String getName() {
        return "remove_first";
    }

    @Override
    public String getDescription() {
        return getName() + "                    -- remove first element from collection";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        collection.stream()
                .filter(route -> Objects.equals(this.user.getUsername(), route.getUser()))
                .findFirst()
                .ifPresent(collection::remove);
    }
}
