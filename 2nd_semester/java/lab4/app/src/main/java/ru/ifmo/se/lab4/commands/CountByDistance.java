package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.PriorityQueue;

public class CountByDistance implements Command{
    public String getName(){
        return "count_by_distance";
    }

    public String getDescription(){
        return getName() + " distance      -- count all elements from collection which distance is equal to the given\n";
    }

    public void execute(PriorityQueue<Route> collection, String [] args){
        long distance = Long.parseLong(args[0]);
        int counter = 0;

        for(Route r: collection){
            if (r.getDistance() == distance){
                counter++;
            }
        }

        String output = "Number of Routes with distance " + distance + ": " + counter;
        IOHandler.println(output);
    }
}