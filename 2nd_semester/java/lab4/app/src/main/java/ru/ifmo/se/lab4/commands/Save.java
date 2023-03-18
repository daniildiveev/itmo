package ru.ifmo.se.lab4.commands;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.io.FileOutputStream;
import ru.ifmo.se.lab4.entities.Route;
import ru.ifmo.se.lab4.handler.IOHandler;

public class Save implements Command{
    public String getName(){
        return "save";
    }
    public String getDescription(){
        return getName() + "                            -- save collection to file\n";
    }

    public void execute(PriorityQueue<Route> collection, String[] args) {
        String savePath = args[0];
        String output = "<routes>";

        for (Route route : collection){
            output += route.toXml();
        }

        output += "</routes>";

        try {
            FileOutputStream fout = new FileOutputStream(savePath, true);
            byte b[] = output.getBytes();
            fout.write(b);
            fout.close();
        }

        catch(Exception e){
            IOHandler.println(e.getMessage());
        }
    }
}
