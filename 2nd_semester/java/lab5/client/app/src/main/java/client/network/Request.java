package client.network;

import common.entities.Route;

import java.io.Serializable;

public class Request implements Serializable {
    private String commandName;
    private String args;
    private Route route;

    public Request(String commandName, String args, Route route){
        this.commandName = commandName;
        this.args = args;
        this.route = route;
    }
}
