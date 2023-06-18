package common.commands.authentication;

import common.exceptions.UserException;
import common.handler.DBHandler;
import common.network.User;

import java.io.ObjectOutput;

public class Login extends AuthenticationCommand{
    @Override
    public String getName(){
        return "login";
    }

    @Override
    public void execute(ObjectOutput objectOut){
        String info;
        int code = 301;
        User user = DBHandler.checkUserPresence(this.user);

        if (user != null){
            try{
                if(DBHandler.checkUserPassword(this.user)){
                    info = "Found user " + this.user.getUsername();
                    code = 201;
                } else {
                    info = "Passwords does not match";
                }
            } catch (UserException e){
                info = e.getMessage();
            }
        } else {
            info = "User does not exist";
        }

        writeResponse(code, info, user, objectOut);
    }
}