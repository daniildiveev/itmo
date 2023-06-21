package common.commands.authentication;

import common.commands.Command;
import common.handler.IOHandler;
import common.network.Response;
import common.network.User;

import java.io.IOException;
import java.io.ObjectOutput;

public abstract class AuthenticationCommand extends Command {
    @Override
    public String getName() {
        return "authentication_command";
    }
}