package common.commands.collection;


import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.PriorityQueue;

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
        collectionHandler.updateCollection(new PriorityQueue<Route>());

        return new Response(201, null, this.user);
    }
}
