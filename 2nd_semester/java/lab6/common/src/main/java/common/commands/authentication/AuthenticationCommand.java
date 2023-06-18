package common.commands.authentication;

import common.commands.Command;
import common.handler.IOHandler;
import common.network.Response;
import common.network.User;

import java.io.IOException;
import java.io.ObjectOutput;

public abstract class AuthenticationCommand implements Command {
    protected User user;

    @Override
    public String getName() {
        return "authentication_command";
    }

    public void setUser(User user){
        this.user = user;
    }

    public void execute(ObjectOutput objectOut){}

    public void writeResponse(int code, String info, User user, ObjectOutput out){
        Response response = new Response(code, info, user);

        try{
            out.writeObject(response);
        } catch (IOException e){
            IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}