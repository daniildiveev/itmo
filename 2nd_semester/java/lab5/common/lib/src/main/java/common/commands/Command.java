package common.commands;

import common.handler.CollectionHandler;

import java.io.Serializable;

public abstract class Command implements Serializable {
    protected static final int numStringsToRead = 12;
    private String[] args = null;
    public String getName(){
        return null;
    };
    public String getDescription(){
        return null;
    };
    public void execute(CollectionHandler collectionHandler){};
    public void setArgs(String[] args){
        this.args = args;
    }
}
