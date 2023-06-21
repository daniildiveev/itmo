package common.commands.collection;

import common.commands.Command;
import common.entities.Route;

public abstract class CommandWithElement extends CollectionCommand {
    protected Route route;

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route r) {
        this.route = r;
    }
}
