package ru.ifmo.se.lab4.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        String savePath = System.getenv("LABA5_SOURCE_FILE");
        String output = "";

        for (Route route : collection){
            output += route.toXml();
        }

        try {
            FileOutputStream fout = new FileOutputStream(savePath, false);
            byte[] b = output.getBytes();
            fout.write(b);
            fout.close();
        }

        catch(FileNotFoundException e){
            IOHandler.println("No such file:" + savePath);
        }

        catch (IOException e){
            IOHandler.println(e.getMessage());
        }
    }
}
