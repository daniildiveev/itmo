package common.commands.collection;

import common.commands.Command;
import common.commands.collection.CollectionCommand;
import common.handler.CollectionHandler;
import common.handler.IOHandler;
import common.handler.PackageParser;
import common.network.Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Response execute(CollectionHandler collectionHandler) {
        try{
            Set<Class> commands = PackageParser.parsePackage("common.commands", new String[]{"Command", "CommandWithElement"});

            String output = commands.stream().map(klass -> {
                try {
                    Command command = (Command) klass.getConstructor().newInstance();
                    CollectionCommand collectionCommand = (CollectionCommand) command;

                    return collectionCommand.getDescription();
                } catch (Exception e) {
                    return "";
                }
            }).collect(Collectors.joining(""));

            return new Response(201, output, this.user);
        } catch (IOException e){
            IOHandler.println(e.getMessage());
            return null;
        }
    }
}
