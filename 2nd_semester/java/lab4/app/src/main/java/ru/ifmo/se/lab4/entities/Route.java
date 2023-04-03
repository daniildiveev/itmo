package ru.ifmo.se.lab4.entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import ru.ifmo.se.lab4.exceptions.InvalidParameterException;
import ru.ifmo.se.lab4.handler.IOHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Route implements Comparable<Route>{

    private static final List<Integer> usedIds  = new ArrayList<>();
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1
    private BufferedReader reader;

    private void fillFields(){
        IOHandler.println("Input now parameters for Route class..");

        this.reader = new BufferedReader(new InputStreamReader(System.in));
        inputName();

        this.coordinates = new Coordinates();
        this.creationDate = LocalDateTime.now();
        this.from = new Location();
        this.to = new Location();

        inputDistance();
    }

    public Route(){
        this.id = generateValidId();
        fillFields();
    }

    public Route(int id){
        if(usedIds.contains(id)){
            IOHandler.println("Route with id " + id + " already exists");
            return;
        }

        if(id < 1){
            IOHandler.println("Id must be greater or equal to 1");
            return;
        }

        this.id = id;
        fillFields();
    }

    public Route(String sourceXml) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(sourceXml));
        Document doc = builder.parse(is);

        Element idElement = (Element) doc.getElementsByTagName("route").item(0);

        try{
            String idValue = idElement.getAttribute("id");

            int id = Integer.parseInt(idValue);

            if (id < 1){
                throw new InvalidParameterException("id parameter must be greater than zero");
            }

            this.id = id;
            usedIds.add(id);
        }
        catch (Exception e){
            IOHandler.println("Id is whether not present or invalid");
        }

        //Parsing fields
        String name = doc.getElementsByTagName("name").item(0).getTextContent().strip();

        if (name.isEmpty()){
            throw new InvalidParameterException("name parameter cannot be null");
        }

        this.name = name;

        String datetime = doc.getElementsByTagName("creationDate")
                             .item(0)
                             .getTextContent()
                             .strip();

        if (datetime.isEmpty() || datetime.equals("null")){
            throw new InvalidParameterException("creationDate parameter cannot be null");
        }

        try{
            this.creationDate = LocalDateTime.parse(datetime);
        }

        catch(Exception e){
            IOHandler.println("Invalid creationDate parameter, moving on to next element...");
            throw new InvalidParameterException("invalid creationDate");
        }

        String distance = doc.getElementsByTagName("distance").item(0).getTextContent();

        if (distance.isEmpty() || distance.equals("null")){
            throw new InvalidParameterException("distance parameter cannot be null");
        }

        try {
            if(Long.parseLong(distance) < 1){
                throw new InvalidParameterException("distance must be greater than 1");
            }
            this.distance = Long.parseLong(distance);
        }

        catch (Exception e){
            IOHandler.println("Invalid distance parameter, moving on to next element...");
            throw new InvalidParameterException("invalid distance");
        }

        //Parsing Location objects
        String xValue, yValue, zValue, nameValue;
        Integer locationX, tmpLocationX = null;
        Float locationY, tmpLocationY = null;
        Double locationZ, tmpLocationZ = null;

        for (String el : new String[] {"from", "to"}){
            Element xmlElement = (Element) doc.getDocumentElement()
                                              .getElementsByTagName(el)
                                              .item(0);

            xValue = xmlElement.getElementsByTagName("x").item(0).getTextContent();
            yValue = xmlElement.getElementsByTagName("y").item(0).getTextContent();
            zValue = xmlElement.getElementsByTagName("z").item(0).getTextContent();
            nameValue = xmlElement.getElementsByTagName("name").item(0).getTextContent();

            if (nameValue.isEmpty() || nameValue.equals("null")){
                throw new InvalidParameterException("name cannot be null");
            }

            if (xValue.equals("null") || xValue.isEmpty()){
                throw new InvalidParameterException("x cannot be null");
            }

            try{
                tmpLocationX = Integer.parseInt(xValue);
            }
            catch (Exception e){}
            finally {
                locationX = tmpLocationX;
            }

            try{
                tmpLocationY = Float.parseFloat(yValue);
            }
            catch (Exception e){}
            finally {
                locationY = tmpLocationY;
            }

            try{
                tmpLocationZ = Double.parseDouble(zValue);
            }
            catch (Exception e){}
            finally {
                locationZ = tmpLocationZ;
            }

            if (el.equals("from")){
                this.from = new Location(locationX, locationY, locationZ, name);
            }
            else if (el.equals("to")){
                this.to = new Location(locationX, locationY, locationZ, name);
            }
        }

        Long coordinatesX, tmpCoordinatesX = null;
        Integer coordinatesY, tmpCoordinatesY = null;

        //Parsing Coordinates object
        Element xmlElement = (Element) doc.getDocumentElement()
                .getElementsByTagName("coordinates")
                .item(0);

        xValue = xmlElement.getElementsByTagName("x").item(0).getTextContent();
        yValue = xmlElement.getElementsByTagName("y").item(0).getTextContent();

        try{
            tmpCoordinatesX = Long.parseLong(xValue);
        }
        catch (Exception e){}
        finally {
            coordinatesX = tmpCoordinatesX;
        }

        try{
            tmpCoordinatesY = Integer.parseInt(yValue);
        }
        catch (Exception e){}
        finally {
            coordinatesY = tmpCoordinatesY;
        }

        this.coordinates = new Coordinates(coordinatesX, coordinatesY);
    }

    public Route(List<String> elements, int id) throws Exception{
        if(id == -1){
            this.id = generateValidId();
        }
        else{
            this.id = id;
        }

        this.creationDate = LocalDateTime.now();

        String name = elements.get(0);

        if (name.isEmpty()){
            throw new InvalidParameterException("name cannot be null");
        }

        try {
            this.coordinates = new Coordinates(Long.parseLong(elements.get(1)),
                                               Integer.parseInt(elements.get(2)));
        }
        catch (Exception e){
            throw new InvalidParameterException("invalid values for coordinates parameter");
        }

        try {
            this.from = new Location(Integer.parseInt(elements.get(3)),
                                   Float.parseFloat(elements.get(4)),
                                   Double.parseDouble(elements.get(5)),
                                   elements.get(6));
        }
        catch (Exception e){
            throw new InvalidParameterException("invalid values for From parameter");
        }

        try {
            this.to = new Location(Integer.parseInt(elements.get(7)),
                                   Float.parseFloat(elements.get(8)),
                                   Double.parseDouble(elements.get(9)),
                                   elements.get(10));
        }
        catch (Exception e){
            throw new InvalidParameterException("invalid values for To parameter");
        }

        String distance = elements.get(11);

        if(distance.strip().isEmpty()){
            throw new InvalidParameterException("distance cannot be null");
        }

        try{
            if (Long.parseLong(distance) < 1){
                throw new InvalidParameterException("distance must be greater than 1");
            }

            this.distance = Long.parseLong(distance);
        } catch (Exception e){
            IOHandler.println(e.getMessage());
        }
    }

    private void inputName(){
        IOHandler.print("Please input the name parameter of Route >>");

        try{
            String input = this.reader.readLine();

            if (input == null || input.isEmpty()){
                throw new InvalidParameterException("name parameter cannot be null");
            }

            if (this.name == null){
                this.name = input;
            }
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid name value, please try again...");
            inputName();
        }
    }

    private void inputDistance(){
        IOHandler.print("Please input the distance parameter of Route >>");

        try{
            String input = this.reader.readLine();

            if (Long.parseLong(input) <= 1){
                throw new InvalidParameterException("distance must be greater than 1");
            }

            this.distance = Long.parseLong(input);
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid distance provided, please try again...");
            inputDistance();
        }
    }

    @Override
    public int compareTo(Route r){
        return Long.compare(r.getDistance(), this.distance);
    }

    private int generateValidId(){
        Collections.sort(usedIds);
        int i = 1;

        while(usedIds.contains(i)){
            i++;
        }

        return i;
    }

    public long getDistance(){
        return this.distance;
    }

    public int getId(){
        return this.id;
    }

    public String toXml(){
        String xmlRepresentation = "<route id=\"" + this.id + "\"> \n";
        xmlRepresentation += "\t<name>" + this.name + "</name>\n";
        xmlRepresentation += this.coordinates.toXml();
        xmlRepresentation += "\t<creationDate>" + this.creationDate + " </creationDate>\n";
        xmlRepresentation += "\t<from>\n" + this.from.toXml() + "\t\t</from>\n";
        xmlRepresentation += "\t<to>\n" + this.to.toXml() + "\t\t</to>\n";
        xmlRepresentation += "\t<distance>" + this.distance + "</distance>\n";
        xmlRepresentation += "</route>\n";

        return xmlRepresentation;
    }

    public static void removeId(int id){
        usedIds.remove(id);
    }

    public String toString(){
        String output = "Route: " + this.id + "\n";
        output += "Name: " + this.name + "\n";
        output += this.coordinates.toString() + "\n";
        output += "Date: " + this.creationDate + "\n";
        output += "From " + this.from.toString() + "\n";
        output += "To" + this.to.toString() + "\n";
        output += "Distance: " + this.distance;

        return output;
    }
}