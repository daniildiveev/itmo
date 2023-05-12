package common.entities;

import common.exceptions.InvalidParameterValueException;
import common.handler.IOHandler;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Coordinates implements Serializable {
    private Long x; //Поле не может быть null
    private Integer y; //Максимальное значение поля: 781, Поле не может быть null

    public Coordinates(Long x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){
        Scanner s = new Scanner(System.in);

        inputX(s);
        inputY(s);
    }

    private void inputX(Scanner s){
        IOHandler.print("Please input the x parameter of Coordinates >>");

        try{
            String input = s.nextLine();

            if(input.isEmpty()){
                throw new InvalidParameterValueException("x parameter cannot be null");
            }

            this.x = Long.parseLong(input);
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid x value, please try again...");
            inputX(s);
        }
    }

    private void inputY(Scanner s){
        IOHandler.print("Please input the y parameter of Coordinates >>");

        try{
            String input = s.nextLine();

            if(input.isEmpty() || Integer.parseInt(input) >= 781){
                throw new InvalidParameterValueException("y parameter cannot be null or greater than 781");
            }

            this.y = Integer.parseInt(input);
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid y value, please try again...");
            inputY(s);
        }
    }

    public String toXml(){
        String xmlRepresentation = "\t\t<coordinates>\n";
        xmlRepresentation += "\t\t\t<x>" + this.x + "</x>\n";
        xmlRepresentation += "\t\t\t<y>" + this.y + "</y>\n";
        xmlRepresentation += "\t\t</coordinates>\n";

        return xmlRepresentation;
    }

    public Long getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        if (o == this) return true;

        Coordinates coordinates = (Coordinates) o;

        return Objects.equals(this.x, coordinates.getX()) && Objects.equals(this.y, coordinates.getY());
    }

    @Override
    public int hashCode() {
        return ("@" + this.getClass().getSimpleName() + this.x + this.y).hashCode();
    }

    @Override
    public String toString(){
        return "Coordinates x:" + this.x + " y:" + this.y;
    }
}
