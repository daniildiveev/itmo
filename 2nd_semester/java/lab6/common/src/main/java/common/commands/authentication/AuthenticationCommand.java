package common.commands.authentication;

import common.commands.Command;

public abstract class AuthenticationCommand implements Command {
    @Override
    public String getName() {
        return "authentication_command";
    }
}