package ru.ifmo.se.lab4.handler;

import ru.ifmo.se.lab4.entities.Route;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionHandler {
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private final String pathToCollection = System.getenv("LABA5_SOURCE_FILE");
    private PriorityQueue<Route> collection = new PriorityQueue<Route>();

    public CollectionHandler() throws Exception {
        //Loading file and storing information in string

        if(pathToCollection == null){
            IOHandler.println("There is no environment variable with collection file path");
            return;
        }

        try{
            FileInputStream fis = new FileInputStream(pathToCollection);
            InputStreamReader isr = new InputStreamReader(fis);
            String xml = "";
            int data = isr.read();

            while(data != -1){
                xml += (char) data;
                data = isr.read();
            }

            //Matching XML regex
            List<String> routesXml = new ArrayList<String>();
            Matcher m = Pattern.compile("<route(?:\sid=\"\\d+\")*>[\\s\\S]*?</route>").matcher(xml);

            while (m.find()){
                routesXml.add(m.group());
            }

            //Creating collection
            for (String routeXml: routesXml){
                try{
                    this.collection.add(new Route(routeXml));
                }
                catch (Exception e){
                    IOHandler.println(e.getMessage());
                    IOHandler.println("Skipping this Route...");
                }
            }
        }
        catch (FileNotFoundException e){
            IOHandler.println("Collection file either does not exist or user has no rights to read it");
        }
    }

    public String info(){
        String output = "Collection " + this.collection.getClass().getSimpleName();
        output += " containing " + this.collection.size() + " of object Route. \n";
        output += "Collection created on " + dateCreated + ".\n";
        output += "Collection stored at " + pathToCollection + ".\n";

        return output;
    }

    public void updateCollection(PriorityQueue<Route> collection){
        this.collection = collection;
    }
    public PriorityQueue<Route> getCollection() {
        return this.collection;
    }
}
