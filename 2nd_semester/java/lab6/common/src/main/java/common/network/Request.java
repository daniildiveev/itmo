package common.network;

import common.commands.Command;

import java.io.Serializable;

public class Request implements Serializable {
    private Command command;
    private User user;

    public Request(Command command, User user){
        this.command = command;
        this.user = user;
    }

    public Command getCommand() {
        return command;
    }

    public User getUser() {
        return user;
    }
}
