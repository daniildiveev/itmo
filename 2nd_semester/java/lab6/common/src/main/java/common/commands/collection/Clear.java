package common.commands.collection;


import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Clear extends CollectionCommand {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return getName() + "                           -- clear the whole collection";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        PriorityQueue<Route> newCollection = collection.stream()
                .filter(route -> this.user.getUsername() != route.getUser())
                .collect(Collectors.toCollection(PriorityQueue::new));

        collectionHandler.updateCollection(newCollection);

        return new Response(201, null, this.user);
    }
}
