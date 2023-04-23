package common.entities;

import java.io.Serializable;

public class Location implements Serializable {
    private Integer x; //Поле не может быть null
    private Float y;
    private Double z;
    private String name; //Строка не может быть пустой, Поле не может быть null
    public Location(Integer x, Float y, Double z, String name){
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
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
