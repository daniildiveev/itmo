package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.PriorityQueue;

public class RemoveById extends CommandWithUser {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return getName() + " id                 -- remove element with respect to id";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        try {
            int targetId = Integer.parseInt(this.args[0]);

            collection.stream()
                    .filter(route -> Objects.equals(this.user.getUsername(), route.getUser()))
                    .filter(route -> route.getId() == targetId)
                    .findFirst()
                    .ifPresent(collection::remove);

        } catch (NumberFormatException e) {
            output.println("Invalid id provided");
        }
    }
}
