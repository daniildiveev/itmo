package common.commands;

import common.entities.Route;

public abstract class CommandWithElement extends Command{
    protected Route route;
    public void executeFromFile(){}
    public void setRoute(Route r){
        this.route = r;
    }

    public Route getRoute(){
        return this.route;
    }
}
