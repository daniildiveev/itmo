package common.entities;

import common.exceptions.InvalidParameterValueException;
import common.handler.IOHandler;

import java.io.Serializable;
import java.util.Scanner;

public class Location implements Serializable {
    private Integer x; //Поле не может быть null
    private Float y;
    private Double z;
    private String locationName; //Строка не может быть пустой, Поле не может быть null
    public Location(Integer x, Float y, Double z, String name){
        this.x = x;
        this.y = y;
        this.z = z;
        this.locationName = name;
    }

    public Location(){
        Scanner s = new Scanner(System.in);
        inputX(s);
        inputY(s);
        inputZ(s);
        inputName(s);
    }

    private void inputX(Scanner s){
        IOHandler.print("Please input the x parameter of Location >>");

        try{
            String input = s.nextLine();

            if(input.isEmpty()){
                throw new InvalidParameterValueException("x cannot be null");
            }

            if (this.x == null){
                this.x = Integer.parseInt(input);
            }
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid x value, please try again...");
            inputX(s);
        }
    }

    private void inputY(Scanner s){
        IOHandler.print("Please input the y parameter of Location >>");

        try{
            String input = s.nextLine();

            if (!input.isEmpty()){
                this.z = Double.parseDouble(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid y value, please try again...");
            inputY(s);
        }
    }

    private void inputZ(Scanner s){
        IOHandler.print("Please input the z parameter of Location >>");

        try{
            String input = s.nextLine();

            if (!input.isEmpty()){
                this.z = Double.parseDouble(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid z value, please try again...");
            inputZ(s);
        }
    }

    private void inputName(Scanner s){
        IOHandler.print("Please input the name parameter of Location >>");

        try{
            String input = s.nextLine();

            if (input.isEmpty()){
                throw new InvalidParameterValueException("name cannot be null");
            }

            if (this.locationName == null){
                this.locationName = input;
            }
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid name value, please try again...");
            inputName(s);
        }
    }

    public String toXml(){
        String xmlRepresentation = "\t\t\t<x>" + this.x + "</x>\n";
        xmlRepresentation += "\t\t\t<y>" + this.y + "</y>\n";
        xmlRepresentation += "\t\t\t<z>" + this.z + "</z>\n";
        xmlRepresentation += "\t\t\t<name>" + this.locationName + "</name>\n";

        return xmlRepresentation;
    }

    public String toString(){
        return "Location " + this.locationName + ": x:" + this.x + " y:" + this.y + " z:" + this.z;
    }
}
