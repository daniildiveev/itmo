package server.commands;

import common.commands.collection.CollectionCommand;
import common.handler.CollectionHandler;
import common.handler.DBHandler;

import java.util.Objects;

public class Save extends CollectionCommand {
    @Override
    public String getName(){
        return "save";
    }

    public void save(CollectionHandler collectionHandler) {
        DBHandler.removeAllUserRoutes(this.user);

        collectionHandler.getCollection().stream()
                .filter(r -> Objects.equals(r.getUser(), this.user.getUsername()))
                .forEach(r -> DBHandler.createRoute(r, this.user, false));
    }
}
