package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.handler.DBHandler;

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
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        Route route = DBHandler.createRoute(this.route, this.user);

        if(route != null){
            PriorityQueue<Route> collection = collectionHandler.getCollection();
            collection.add(route);
            collectionHandler.updateCollection(collection);
        }
    }
}
