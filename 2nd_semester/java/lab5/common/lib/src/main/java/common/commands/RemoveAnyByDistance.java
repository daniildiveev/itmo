package common.commands;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class RemoveAnyByDistance extends Command{
    @Override
    public String getName() {
        return "remove_any_by_distance";
    }

    @Override
    public String getDescription() {
        return getName() + " distance -- remove any element from collection which distance is equal to the given\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        try {
            long targetDistance = Long.parseLong(this.args[0]);

            collection.stream()
                    .filter(route -> route.getDistance() == targetDistance)
                    .findAny()
                    .ifPresent(collection::remove);
        } catch (Exception e){
            output.println("Invalid distance provided");
        }
    }
}
