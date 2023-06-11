package common.commands.collection;

import common.entities.Route;

public abstract class CommandWithElement extends CollectionCommand {
    protected Route route;

    public void executeFromFile() {
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route r) {
        this.route = r;
    }
}
