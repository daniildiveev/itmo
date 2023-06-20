package common.commands.collection;

import common.entities.Route;
import common.network.User;

public abstract class CommandWithElement extends CollectionCommand {
    protected Route route;
    protected User user;

    public void executeFromFile() {
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route r) {
        this.route = r;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
