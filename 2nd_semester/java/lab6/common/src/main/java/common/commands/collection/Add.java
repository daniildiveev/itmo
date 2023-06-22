package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.handler.DBHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Add extends CommandWithElement {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return getName() + "                             -- add new element to collection";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        Route route = DBHandler.createRoute(this.route, this.user, true);

        if(route != null){
            PriorityQueue<Route> collection = collectionHandler.getCollection();
            collection.add(route);
            collectionHandler.updateCollection(collection);
        }

        return new Response(201, null, this.user);
    }
}
