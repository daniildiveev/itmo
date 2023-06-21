package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PrintUniqueDistance extends CollectionCommand {
    @Override
    public String getName() {
        return "print_unique_distance";
    }

    @Override
    public String getDescription() {
        return getName() + "           -- show unique distances";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        String output = collection.stream()
                .map(Route::getDistance)
                .distinct()
                .map(distance -> Long.toString(distance))
                .collect(Collectors.joining("\n"));

        return new Response(201, output, this.user);
    }
}
