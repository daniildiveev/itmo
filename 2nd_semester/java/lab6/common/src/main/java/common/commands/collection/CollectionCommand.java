package common.commands.collection;

import common.commands.Command;
import common.handler.CollectionHandler;
import common.network.Response;

import java.io.PrintWriter;

public abstract class CollectionCommand extends Command {
    protected static final int numStringsToRead = 12;
    protected String[] args = null;

    public static int getNumStringsToRead() {
        return numStringsToRead;
    }
    public String getDescription() {
        return null;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
