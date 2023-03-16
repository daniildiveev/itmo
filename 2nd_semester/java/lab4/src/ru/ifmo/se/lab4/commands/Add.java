package ru.ifmo.se.lab4.commands;

import java.util.PriorityQueue;
import ru.ifmo.se.lab4.entities.Route;

public class Add implements Command{
    public String getName(){
        return "add";
    }

    public String getDescription(){
        return getName() + "                   -- add new element to collection\n";
    }

    public void execute(PriorityQueue<Route> collection, String[] args){
        Route route = new Route();
        collection.add(route);
    }
}