package common.handler;

import common.commands.CommandWithElement;
import common.entities.Route;
import common.setter.RouteAutomaticFieldsSetter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionHandler {
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private final String pathToCollection = System.getenv("LABA5_SOURCE_FILE");
    private PriorityQueue<Route> collection = new PriorityQueue<>();

    public CollectionHandler() throws Exception {
        //Loading file and storing information in string

        if(pathToCollection == null){
            IOHandler.println("There is no environment variable with collection file path");
            return;
        }

        File file = FileHandler.process(pathToCollection);

        if (file != null) {
            FileInputStream fis = new FileInputStream(pathToCollection);
            InputStreamReader isr = new InputStreamReader(fis);
            String xml = "";
            int data = isr.read();

            while (data != -1) {
                xml += (char) data;
                data = isr.read();
            }

            //Matching XML regex
            List<String> routesXml = new ArrayList<String>();
            Matcher m = Pattern.compile("<route(?:\sid=\"\\d+\")*>[\\s\\S]*?</route>").matcher(xml);

            while (m.find()) {
                routesXml.add(m.group());
            }

            //Creating collection
            for (String routeXml : routesXml) {
                try {
                    this.collection.add(createRouteFromXml(routeXml));
                } catch (Exception e) {
                    IOHandler.println(e.getMessage());
                    IOHandler.println("Skipping this Route...");
                }
            }
        }
    }

    public Route createRouteFromXml(String sourceXml) throws Exception{
        String[] args = new String[CommandWithElement.getNumStringsToRead()];
        int i = 0;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(sourceXml));
        Document doc = builder.parse(is);

        Element idElement = (Element) doc.getElementsByTagName("route").item(0);

        String idValue = idElement.getAttribute("id");
        RouteAutomaticFieldsSetter.validateId(idValue);

        String datetime = doc.getElementsByTagName("creationDate")
                .item(0)
                .getTextContent()
                .trim();
        RouteAutomaticFieldsSetter.validateCreationDate(datetime);

        String name = doc.getElementsByTagName("name").item(0).getTextContent().trim();
        args[i++] = name;

        //Parsing coordinates object
        Element xmlElement = (Element) doc.getDocumentElement()
                .getElementsByTagName("coordinates")
                .item(0);

        args[i++] = xmlElement.getElementsByTagName("x").item(0).getTextContent();
        args[i++] = xmlElement.getElementsByTagName("y").item(0).getTextContent();

        //Parsing location fields
        for (String el : new String[] {"from", "to"}) {
            xmlElement = (Element) doc.getDocumentElement()
                    .getElementsByTagName(el)
                    .item(0);

            args[i++] = xmlElement.getElementsByTagName("x").item(0).getTextContent();
            args[i++] = xmlElement.getElementsByTagName("y").item(0).getTextContent();
            args[i++] = xmlElement.getElementsByTagName("z").item(0).getTextContent();
            args[i++] = xmlElement.getElementsByTagName("name").item(0).getTextContent();
        }

        args[i++] = doc.getElementsByTagName("distance").item(0).getTextContent();

        Route r = new Route(args);
        r.setCreationDate(LocalDateTime.parse(datetime));
        r.setId(Integer.parseInt(idValue));

        return r;
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
