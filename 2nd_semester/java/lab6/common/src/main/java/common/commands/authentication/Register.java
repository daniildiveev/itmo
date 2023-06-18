package common.commands.authentication;

import common.exceptions.UserException;
import common.handler.DBHandler;
import common.network.User;

import java.io.ObjectOutput;

public class Register extends AuthenticationCommand {
    @Override
    public String getName() {
        return "register";
    }

    @Override
    public void execute(ObjectOutput objectOut) {
        String info;
        int code = 301;
        User user = null;

        if(DBHandler.checkUserPresence(this.user) != null){
            info = "User already exists";
        } else {
            try{
                user = DBHandler.createUser(this.user);

                if(user != null){
                    info = "User successfully created";
                    code = 201;
                } else {
                    info = "SQL error";
                }
            } catch (UserException e){
                info = e.getMessage();
            }
        }

        writeResponse(code, info, user, objectOut);
    }
}