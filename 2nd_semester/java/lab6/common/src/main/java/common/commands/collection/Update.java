package common.commands.collection;

import common.entities.Route;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;

public class Update extends CommandWithElement {
    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return getName() + " id {element}             -- update collection element with respect to id";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        String output = null;

        try {

            int idToChange = Integer.parseInt(this.args[0]);
            PriorityQueue<Route> collection = collectionHandler.getCollection();

            Optional<Route> route = collection.stream()
                    .filter(r -> Objects.equals(this.user.getUsername(), r.getUser()))
                    .filter(r -> r.getId() == idToChange)
                    .findFirst();

            if (route.isPresent()) {
                collection.remove(route.get());
                this.route.setId(route.get().getId());
                collection.add(this.route);
            } else {
                output = "Element with provided id not found in collection";
            }
        } catch (NumberFormatException e) {
            output = "Invalid id provided";
        }

        return new Response(201, output, this.user);
    }
}
