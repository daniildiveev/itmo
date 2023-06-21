package common.commands.authentication;

import common.exceptions.UserException;
import common.handler.CollectionHandler;
import common.handler.DBHandler;
import common.handler.IOHandler;
import common.network.Response;
import common.network.User;

public class Login extends AuthenticationCommand{
    @Override
    public String getName(){
        return "login";
    }

    @Override
    public Response execute(CollectionHandler collectionHandler){
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

        return new Response(code, info, this.user);
    }
}