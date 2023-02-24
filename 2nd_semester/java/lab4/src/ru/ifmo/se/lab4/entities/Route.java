package ru.ifmo.se.lab4.entities;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import ru.ifmo.se.lab4.exceptions.InvalidParameterException;
import ru.ifmo.se.lab4.handler.IOHandler;

public class Route implements Comparable<Route>{
    private static int id_next=1;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1
    private BufferedReader reader;

    public Route(){
        IOHandler.println("Input now parameters for Route class..");
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        this.id = id_next;
        id_next++;

        inputName();

        this.coordinates = new Coordinates();
        this.creationDate = LocalDateTime.now();
        this.from = new Location();
        this.to = new Location();

        inputDistance();
    }

    private void inputName(){
        IOHandler.print("Please input the name parameter of Route >>");

        try{
            String input = this.reader.readLine();

            if (input.equals("") || input == null){
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
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid distance provided, please try again...");
            inputDistance();
        }
    }

    public int compareTo(Route r){
        return (int) (r.distance - this.distance);        
    }

    public int getId(){
        return this.id;
    }

    public String toXml(){
        String xmlRepresentation = "\t<route id=\"" + Integer.toString(this.id) + "\"> \n";
        xmlRepresentation += "\t\t<name>" + this.name + "\t\t</name>\n";
        xmlRepresentation += this.coordinates.toXml();
        xmlRepresentation += "\t\t<creationDate>\n" + this.creationDate.toString() + "\t\t</creationDate>\n";
        xmlRepresentation += "\t\t<from>\n" + this.from.toXml() + "\t\t</from>\n";
        xmlRepresentation += "\t\t<to>\n" + this.to.toXml() + "\t\t</to>\n";
        xmlRepresentation += "\t\t<distance>" + Long.toString(this.distance) + "</distance>\n";
        xmlRepresentation += "\t</route>\n";

        return xmlRepresentation;
    }
}