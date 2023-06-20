package common.commands.collection;

import common.entities.Route;
import common.network.User;

public abstract class CommandWithElement extends CommandWithUser {
    protected Route route;

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route r) {
        this.route = r;
    }
}
