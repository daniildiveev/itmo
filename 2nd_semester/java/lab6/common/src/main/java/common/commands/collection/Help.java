package common.commands;

import common.handler.CollectionHandler;
import common.handler.PackageParser;

import java.io.PrintWriter;
import java.util.Set;

public class Help extends Command{
    @Override
    public String getName(){
        return "help";
    }

    @Override
    public String getDescription(){
        return getName() + "                            -- show information about available commands";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        Set<Class> commands = PackageParser.parsePackage("common.commands", new String[]{"Command", "CommandWithElement"});

        commands.forEach(klass -> {
            try{
                Command command = (Command) klass.getConstructor().newInstance();
                output.println(command.getDescription());
            } catch (Exception e){
                output.println(e.getMessage());
            }
        });
    }
}
