package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.PriorityQueue;

public class RemoveById extends CollectionCommand {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return getName() + " id                 -- remove element with respect to id";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        String output = null;

        try {
            int targetId = Integer.parseInt(this.args[0]);

            collection.stream()
                    .filter(route -> Objects.equals(this.user.getUsername(), route.getUser()))
                    .filter(route -> route.getId() == targetId)
                    .findFirst()
                    .ifPresent(collection::remove);

        } catch (NumberFormatException e) {
            output = "Invalid id provided";
        }

        return new Response(201, output, this.user);
    }
}
