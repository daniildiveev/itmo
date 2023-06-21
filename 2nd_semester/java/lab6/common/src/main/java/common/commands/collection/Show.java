package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Show extends CollectionCommand {
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- show all elements of collection in String representation";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();
        String output;

        if (collection.isEmpty()) {
            output = "Collection is empty!";
        } else {
            output = collection.stream().map(Route::toString).collect(Collectors.joining("\n"));
        }

        return new Response(201, output, this.user);
    }
}

