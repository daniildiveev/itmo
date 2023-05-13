package common.commands;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Exit extends Command{
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return getName() + "                            -- exit client application";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, PrintWriter output) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        String savePath = System.getenv("LABA5_SOURCE_FILE");

        if(savePath == null){
            output.println("There is no environment variable with collection file path");
            return;
        }

        String fileOutput = "<routes>";

        for (Route route : collection){
            fileOutput += route.toXml();
        }

        fileOutput += "</routes>";

        try {
            FileOutputStream fout = new FileOutputStream(savePath, false);
            byte[] b = fileOutput.getBytes();
            fout.write(b);
            fout.close();
        } catch(FileNotFoundException e){
            output.println("No such file:" + savePath);
        } catch (IOException e){
            output.println(e.getMessage());
        }
    }
}
