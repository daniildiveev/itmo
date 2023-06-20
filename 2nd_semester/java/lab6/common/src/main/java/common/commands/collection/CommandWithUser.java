package common.commands.collection;

import common.network.User;

public abstract class CommandWithUser extends CollectionCommand {
    protected User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
