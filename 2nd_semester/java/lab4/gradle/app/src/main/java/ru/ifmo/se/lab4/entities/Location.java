package ru.ifmo.se.lab4.entities;

import java.io.IOException;
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

    private void inputX(){
        IOHandler.print("Please input the x parameter of Location >>");

        try{
            String input = this.reader.readLine();

            if(input.equals("")){
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

            if (!input.equals("")){
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

            if (!input.equals("")){
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

            if (input.equals("") || input == null){
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
        String xmlRepresentation = "\t\t\t<x>" + Integer.toString(this.x) + "</x>\n";

        if (this.y != null){
            xmlRepresentation += "\t\t\t<y>" + Float.toString(this.y) + "</y>\n";
        }

        if (this.x != null){
            xmlRepresentation += "\t\t\t<z>" + Double.toString(this.z) + "</z>\n";
        }

        xmlRepresentation += "\t\t\t<name>" + this.name + "</name>\n";
        
        return xmlRepresentation;
    }
}