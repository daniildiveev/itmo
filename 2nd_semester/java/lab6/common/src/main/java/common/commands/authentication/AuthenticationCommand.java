package common.commands.authentication;

import common.commands.Command;
import common.network.User;

public abstract class AuthenticationCommand implements Command {
    private User user;

    @Override
    public String getName() {
        return "authentication_command";
    }

    public void setUser(User user){
        this.user = user;
    }
}