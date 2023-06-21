package common.commands;

import common.handler.CollectionHandler;
import common.network.Response;
import common.network.User;

import java.io.Serializable;

public abstract class Command implements Serializable{
    protected User user;
    protected static final int numStringsToRead = 12;
    protected String[] args = null;

    public static int getNumStringsToRead() {
        return numStringsToRead;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getName(){
        return "";
    }

    public String getDescription(){
        return "";
    }

    public Response execute(CollectionHandler collectionHandler){
        return null;
    }
}