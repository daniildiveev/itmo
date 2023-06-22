package common.commands.collection;

import common.handler.CollectionHandler;
import common.handler.DBHandler;
import common.network.Response;

import java.util.Objects;


public class Exit extends CollectionCommand {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- exit client application";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler) {
        DBHandler.removeAllUserRoutes(this.user);

        collectionHandler.getCollection().stream()
                .filter(r -> Objects.equals(r.getUser(), this.user.getUsername()))
                .forEach(r -> DBHandler.createRoute(r, this.user, false));

        return new Response(201, null, this.user);
    }
}
