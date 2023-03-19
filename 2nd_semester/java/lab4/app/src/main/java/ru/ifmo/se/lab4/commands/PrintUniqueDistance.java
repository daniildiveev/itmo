package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrintUniqueDistance implements Command{
    @Override
    public String getName(){
        return "print_unique_distance";
    }

    @Override
    public String getDescription(){
        return getName() + "           -- show unique distances\n";
    }

    @Override
    public void execute(PriorityQueue<Route> collection, String [] args){
        Set<Long> distances = new HashSet<>();
        String output = "";

        for(Route r:collection){
            distances.add(r.getDistance());
        }

        for(Long l:distances){
            output += l.toString() + " ";
        }

        IOHandler.println(output);
    }
}
