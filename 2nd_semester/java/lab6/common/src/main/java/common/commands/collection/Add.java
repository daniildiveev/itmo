package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.setter.RouteAutomaticFieldsSetter;

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
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        executionMessage(output);

        this.route.setId(RouteAutomaticFieldsSetter.generateValidId(collectionHandler));
        this.route.setCreationDate(RouteAutomaticFieldsSetter.generateTimestamp());

        collection.add(this.route);
        collectionHandler.updateCollection(collection);
    }
}
