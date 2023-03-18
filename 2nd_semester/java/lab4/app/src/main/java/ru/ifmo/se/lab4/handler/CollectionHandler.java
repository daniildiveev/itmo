package ru.ifmo.se.lab4.handler;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import ru.ifmo.se.lab4.entities.Route;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class CollectionHandler {
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private final String pathToCollection = System.getenv("LABA5_SOURCE_FILE");
    private PriorityQueue<Route> collection;

    public CollectionHandler() throws Exception {
        //Loading file and storing information in string
        FileInputStream fis = new FileInputStream(pathToCollection);
        String xml = "";
        int i;

        while ((i=fis.read()) != -1) {
            xml += (char) i;
        }

        //Parsing XML from string
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);

        NodeList routes = doc.getElementsByTagName("route");

        //Iterating over parsed objects
        for (i = 0; i < routes.getLength(); i++){
            Node child = routes.item(i);
            String name = child.getNodeName();
            String contents = child.getTextContent();
        }
    }

    public String info(){
        String output = "Collection " + collection.getClass().getSimpleName();
        output += " containing " + collection.size() + " of object Route. \n";
        output += " Collection created on " + dateCreated + ".\n";
        output += " Collection stored at " + pathToCollection + ".\n";

        return output;
    }

    void updateCollection(PriorityQueue<Route> collection){
        this.collection = collection;
    }
    public PriorityQueue<Route> getCollection() {
        return collection;
    }
}
