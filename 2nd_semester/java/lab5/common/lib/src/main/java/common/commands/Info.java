package common.commands;

import common.handler.CollectionHandler;

import java.io.PrintWriter;

public class Info extends Command{
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- show information about collection (type, initialization date, number of elements)";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        output.println(collectionHandler.info());
    }
}
