package common.commands;

import common.entities.Route;

public class CommandWithElement extends Command{
    protected Route route;
    public void executeFromFile(){}
    public void setRoute(Route r){
        this.route = r;
    }
}
