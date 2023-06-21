package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class CountByDistance extends CollectionCommand {
    @Override
    public String getName() {
        return "count_by_distance";
    }

    @Override
    public String getDescription() {
        return getName() + " distance      -- count all elements from collection which distance is equal to the given";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        String output;

        try {
            long distance = Long.parseLong(this.args[0]);

            long matchingDistanceCounter = collection.stream()
                    .filter(route -> route.getDistance() == distance)
                    .count();

            output = "Number of Routes with distance " + distance + ": " + matchingDistanceCounter;

        } catch (NumberFormatException e) {
            output = "Invalid distance provided";
        }

        return new Response(201, output, this.user);
    }
}
