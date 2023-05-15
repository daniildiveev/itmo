package common.commands;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class PrintUniqueDistance extends Command{
    @Override
    public String getName(){
        return "print_unique_distance";
    }

    @Override
    public String getDescription(){
        return getName() + "           -- show unique distances";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        collection.stream()
                .map(Route::getDistance)
                .distinct()
                .forEach(output::println);
    }
}
