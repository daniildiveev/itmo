package server.commands;

import common.commands.collection.CollectionCommand;
import common.entities.Route;
import common.handler.CollectionHandler;
import common.handler.IOHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.PriorityQueue;

public class Save extends CollectionCommand {
    @Override
    public String getName(){
        return "save";
    }

    public void save(CollectionHandler collectionHandler) {
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        String savePath = System.getenv("LABA5_SOURCE_FILE");

        if(savePath == null){
            System.out.println("There is no environment variable with collection file path");
            return;
        }

        String xmlOutput = "<routes>\n";

        for (Route route : collection){
            xmlOutput += route.toXml();
        }

        xmlOutput += "</routes>";

        try {
            FileOutputStream fout = new FileOutputStream(savePath, false);
            byte[] b = xmlOutput.getBytes();
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
