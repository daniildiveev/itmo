package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.PriorityQueue;

public class Show implements Command{
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "                            -- show all elements of collection in String representation\n";
    }

    @Override
    public void execute(PriorityQueue<Route> collection, String[] args) {
        for(Route r: collection){
            IOHandler.println(r.toString());
            IOHandler.println("");
        }
    }
}
