package ru.ifmo.se.lab4.handler;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import ru.ifmo.se.lab4.entities.Route;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class CollectionHandler {
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private final String pathToCollection = System.getenv("LABA5_SOURCE_FILE");
    private PriorityQueue<Route> collection;

    public CollectionHandler() throws Exception {
        //TODO: implement loading collection from file
        String xml = "";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
    }

    public String info(){
        String output = "Collection " + collection.getClass().getSimpleName();
        output += " containing " + collection.size() + " of object Route. ";
        output += " Collection created on " + dateCreated.toString() + ".";

        return output;
    }

    void updateCollection(PriorityQueue<Route> collection){
        this.collection = collection;
    }
    public PriorityQueue<Route> getCollection() {
        return collection;
    }
}
