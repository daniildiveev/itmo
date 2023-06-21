package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class RemoveGreater extends CommandWithElement {
    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return getName() + " {element}        -- remove all elements from collection that is greater than given";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        PriorityQueue<Route> updatedCollection = collection.stream()
                .filter(route -> Objects.equals(this.user.getUsername(), route.getUser()))
                .filter(route -> this.route.compareTo(route) <= 0)
                .collect(Collectors.toCollection(PriorityQueue::new));

        collectionHandler.updateCollection(updatedCollection);

        return new Response(201, null, this.user);
    }
}
