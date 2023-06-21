package common.commands.collection;

import common.commands.Command;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;
import java.io.Serializable;

public abstract class CollectionCommand implements Command {
    protected static final int numStringsToRead = 12;
    protected String[] args = null;

    public static int getNumStringsToRead() {
        return numStringsToRead;
    }
    public String getDescription() {
        return null;
    }
    public Response execute(CollectionHandler collectionHandler) {
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void executionMessage(PrintWriter output) {
        output.println("Executing command " + getName());
    }
}
