package ru.ifmo.se.lab4.commands;

import java.util.PriorityQueue;
import ru.ifmo.se.lab4.entities.Route;

public class Add implements Command{
    @Override
    public String getName(){
        return "add";
    }

    @Override
    public String getDescription(){
        return getName() + "                             -- add new element to collection\n";
    }

    @Override
    public void execute(PriorityQueue<Route> collection, String[] args){
        Route route = new Route();
        collection.add(route);
    }
}