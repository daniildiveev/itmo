package common.commands.collection;

import common.commands.Command;
import common.network.User;

public abstract class RemoveCommand implements Command {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
