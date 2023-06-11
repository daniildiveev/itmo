package common.commands.collection;

import common.commands.Command;
import common.handler.CollectionHandler;

import java.io.PrintWriter;
import java.io.Serializable;

public abstract class CollectionCommand implements Command, Serializable {
    protected static final int numStringsToRead = 12;
    protected String[] args = null;

    public static int getNumStringsToRead() {
        return numStringsToRead;
    }
    public String getDescription() {
        return null;
    }
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void executionMessage(PrintWriter output) {
        output.println("Executing command " + getName());
    }
}
