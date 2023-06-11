package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;

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
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        try {
            long distance = Long.parseLong(this.args[0]);

            long matchingDistanceCounter = collection.stream()
                    .filter(route -> route.getDistance() == distance)
                    .count();

            output.println("Number of Routes with distance " + distance + ": " + matchingDistanceCounter);

        } catch (NumberFormatException e) {
            output.println("Invalid distance provided");
        }
    }
}
