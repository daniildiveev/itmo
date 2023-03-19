package ru.ifmo.se.lab4.commands;

import java.util.PriorityQueue;
import java.util.Set;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.IOHandler;
import ru.ifmo.se.lab4.handler.PackageParser;

public class Help implements Command{
    @Override
    public String getName(){
        return "help";
    }

    @Override
    public String getDescription(){
        return getName() + "                            -- show information about available commands\n";
    }

    @Override
    public void execute(PriorityQueue<Route> collection, String[] args){
        Set<Class> commands = PackageParser.parsePackage("ru.ifmo.se.lab4.commands", "Command");
        String output = "";

        for(Class klass: commands){
            try{
                Command command = (Command) klass.getConstructor().newInstance();
                output +=  command.getDescription();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        IOHandler.println(output);
    }
}