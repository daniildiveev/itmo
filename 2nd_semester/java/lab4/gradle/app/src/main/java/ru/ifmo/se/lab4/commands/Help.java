package ru.ifmo.se.lab4.commands;

import java.util.PriorityQueue;
import ru.ifmo.se.lab4.entities.Route;
public class Help implements Command{
    public String getName(){
        return "help";
    }

    public String getDescription(){
        return getName() + "                            -- show information about available commands\n";
    }
    public void execute(PriorityQueue<Route> collection, String[] args){
        System.out.println("Not implemented yet");
    }
}