package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.util.Objects;
import java.util.PriorityQueue;

public class RemoveAnyByDistance extends CollectionCommand {
    @Override
    public String getName() {
        return "remove_any_by_distance";
    }

    @Override
    public String getDescription() {
        return getName() + " distance -- remove any element from collection which distance is equal to the given";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        String output = null;

        try {
            long targetDistance = Long.parseLong(this.args[0]);

            collection.stream()
                    .filter(route -> Objects.equals(this.user.getUsername(), route.getUser()))
                    .filter(route -> route.getDistance() == targetDistance)
                    .findAny()
                    .ifPresent(collection::remove);
        } catch (Exception e) {
            output = "Invalid distance provided";
        }

        return new Response(201, output, this.user);
    }
}
