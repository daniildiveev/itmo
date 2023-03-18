package ru.ifmo.se.lab4.entities;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import ru.ifmo.se.lab4.handler.IOHandler;
import ru.ifmo.se.lab4.exceptions.InvalidParameterException;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Максимальное значение поля: 781, Поле не может быть null
    private BufferedReader reader;

    public Coordinates(){
        IOHandler.println("Input now for parameters of Coordinates class..");
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        inputX();
        inputY();
    }

    public Coordinates(Long x, Integer y) throws InvalidParameterException{
        if (x == null){
            throw new InvalidParameterException("x parameter cannot be null");
        }

        if (y == null || y >= 781) {
            throw new InvalidParameterException("y parameter cannot be null");
        }

        this.x = x;
        this.y = y;
    }

    private void inputX(){
        IOHandler.print("Please input the x parameter of Coordinates >>");

        try{
            String input = this.reader.readLine();

            if(input.equals("")){
                throw new InvalidParameterException("x parameter cannot be null");
            }

            if (this.x != null){
                this.x = Long.parseLong(input);
            }
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid x value, please try again...");
            inputX();
        }
    }

    private void inputY(){
        IOHandler.print("Please input the y parameter of Coordinates >>");

        try{
            String input = this.reader.readLine();

            if(input.equals("") || Integer.parseInt(input) >= 781){
                throw new InvalidParameterException("y parameter cannot be null or greater than 781");
            }

            if (this.y != null){
                this.y = Integer.parseInt(input);
            }
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid y value, please try again...");
            inputY();
        }
    }

    public String toXml(){
        String xmlRepresentation = "\t\t<coordinates>\n";
        xmlRepresentation += "\t\t\t<x>" + this.x + "</x>\n";
        xmlRepresentation += "\t\t\t<y>" + this.y + "</y>\n";
        xmlRepresentation += "\t\t</coordinates>\n";

        return xmlRepresentation;
    }
}