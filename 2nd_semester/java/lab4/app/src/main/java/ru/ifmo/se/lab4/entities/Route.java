package ru.ifmo.se.lab4.entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import ru.ifmo.se.lab4.exceptions.InvalidParameterException;
import ru.ifmo.se.lab4.handler.IOHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Route implements Comparable<Route>{
    private static int idNext =1;

    private static final List<Integer> usedIds  = new ArrayList<>();
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1
    private BufferedReader reader;

    public Route(){
        IOHandler.println("Input now parameters for Route class..");
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        this.id = idNext++; //TODO: fix id generation

        inputName();

        this.coordinates = new Coordinates();
        this.creationDate = LocalDateTime.now();
        this.from = new Location();
        this.to = new Location();

        inputDistance();
    }

    public Route(String sourceXml) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(sourceXml));
        Document doc = builder.parse(is);

        this.id = idNext++; //TODO: fix id generation

        //Parsing fields
        String name = doc.getElementsByTagName("name").item(0).getTextContent();

        if (name.equals("")){
            throw new InvalidParameterException("name parameter cannot be null");
        }

        this.name = name;

        String datetime = doc.getElementsByTagName("creationDate")
                             .item(0)
                             .getTextContent()
                             .strip();

        if (datetime.equals("") || datetime.equals("null")){
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

        if (distance.equals("") || distance.equals("null")){
            throw new InvalidParameterException("distance parameter cannot be null");
        }

        try {
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

            if (nameValue.equals("") || nameValue.equals("null")){
                throw new InvalidParameterException("name cannot be null");
            }

            if (xValue.equals("null") || xValue.equals("")){
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

    private void inputName(){
        IOHandler.print("Please input the name parameter of Route >>");

        try{
            String input = this.reader.readLine();

            if (input == null || input.equals("")){
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