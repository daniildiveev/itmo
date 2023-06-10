package common.commands;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.setter.RouteAutomaticFieldsSetter;

import java.io.PrintWriter;
import java.util.Optional;
import java.util.PriorityQueue;

public class Update extends CommandWithElement{
    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return getName() + " id {element}             -- update collection element with respect to id";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        try{
            int idToChange = Integer.parseInt(this.args[0]);
            PriorityQueue<Route> collection = collectionHandler.getCollection();

            Optional<Route> route = collection.stream()
                    .filter(r -> r.getId() == idToChange)
                    .findFirst();

            if(route.isPresent()){
                collection.remove(route.get());
                this.route.setId(route.get().getId());
                this.route.setCreationDate(RouteAutomaticFieldsSetter.generateTimestamp());
                collection.add(this.route);
            } else {
                output.println("Element with provided id not found in collection");
            }
        } catch (NumberFormatException e){
            output.println("Invalid id provided");
        }
    }
}
