package ru.ifmo.se.lab4.entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ru.ifmo.se.lab4.handler.IOHandler;
import ru.ifmo.se.lab4.exceptions.InvalidParameterException;

public class Location{
    private Integer x; //Поле не может быть null
    private Float y;
    private Double z;
    private String name; //Строка не может быть пустой, Поле не может быть null
    private BufferedReader reader;

    public Location(){
        IOHandler.println("Input now for parameters of Location class..");
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        inputX();
        inputY();
        inputZ();
        inputName();
    }

    public Location(Integer x, Float y, Double z, String name) throws InvalidParameterException {
        if (x == null) {
            throw new InvalidParameterException("x cannot be null");
        }

        if (name == null) {
            throw new InvalidParameterException("name cannot be null");
        }

        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;

    }

    private void inputX(){
        IOHandler.print("Please input the x parameter of Location >>");

        try{
            String input = this.reader.readLine();

            if(input.isEmpty()){
                throw new InvalidParameterException("x cannot be null");
            }

            if (this.x == null){
                this.x = Integer.parseInt(input);
            }
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid x value, please try again...");
            inputX();
        }
    }

    private void inputY(){
        IOHandler.print("Please input the y parameter of Location >>");

        try{
            String input = this.reader.readLine();

            if (!input.isEmpty()){
                this.z = Double.parseDouble(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid y value, please try again...");
            inputY();
        }
    }

    private void inputZ(){
        IOHandler.print("Please input the z parameter of Location >>");

        try{
            String input = this.reader.readLine();

            if (!input.isEmpty()){
                this.z = Double.parseDouble(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid z value, please try again...");
            inputZ();
        }
    }

    private void inputName(){
        IOHandler.print("Please input the name parameter of Location >>");

        try{
            String input = this.reader.readLine();

            if (input.isEmpty()){
                throw new InvalidParameterException("name cannot be null");
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

    public String toXml(){
        String xmlRepresentation = "\t\t\t<x>" + this.x + "</x>\n";
        xmlRepresentation += "\t\t\t<y>" + this.y + "</y>\n";
        xmlRepresentation += "\t\t\t<z>" + this.z + "</z>\n";
        xmlRepresentation += "\t\t\t<name>" + this.name + "</name>\n";
        
        return xmlRepresentation;
    }

    public String toString(){
        return "Location " + this.name + ": x:" + this.x + " y:" + this.y + " z:" + this.z;
    }
}