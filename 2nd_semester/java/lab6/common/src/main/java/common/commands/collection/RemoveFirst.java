package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.PriorityQueue;

public class RemoveFirst extends CollectionCommand {
    @Override
    public String getName() {
        return "remove_first";
    }

    @Override
    public String getDescription() {
        return getName() + "                    -- remove first element from collection";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        collection.stream()
                .filter(route -> Objects.equals(this.user.getUsername(), route.getUser()))
                .findFirst()
                .ifPresent(collection::remove);

        return new Response(201, null, this.user);
    }
}
