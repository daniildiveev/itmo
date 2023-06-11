package common.commands.collection;

import common.commands.Command;
import common.commands.collection.CollectionCommand;
import common.handler.CollectionHandler;
import common.handler.IOHandler;
import common.handler.PackageParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class Help extends CollectionCommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- show information about available commands";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        try{
            Set<Class> commands = PackageParser.parsePackage("common.commands", new String[]{"Command", "CommandWithElement"});

            commands.forEach(klass -> {
                try {
                    Command command = (Command) klass.getConstructor().newInstance();
                    CollectionCommand collectionCommand = (CollectionCommand) command;
                    output.println(collectionCommand.getDescription());
                } catch (Exception e) {
                    output.println(e.getMessage());
                }
            });
        } catch (IOException e){
            IOHandler.println(e.getMessage());
        }
    }
}
