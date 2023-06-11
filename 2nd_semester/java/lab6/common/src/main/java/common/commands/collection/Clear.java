package common.commands.collection;


import common.entities.Route;
import common.handler.CollectionHandler;

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
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        collectionHandler.updateCollection(new PriorityQueue<Route>());
    }
}
