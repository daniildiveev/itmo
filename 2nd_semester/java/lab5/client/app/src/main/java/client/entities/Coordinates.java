package client.entities;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Максимальное значение поля: 781, Поле не может быть null

    public Coordinates(Long x, Integer y){
        this.x = x;
        this.y = y;
    }

    public String toXml(){
        String xmlRepresentation = "\t\t<coordinates>\n";
        xmlRepresentation += "\t\t\t<x>" + this.x + "</x>\n";
        xmlRepresentation += "\t\t\t<y>" + this.y + "</y>\n";
        xmlRepresentation += "\t\t</coordinates>\n";

        return xmlRepresentation;
    }

    public String toString(){
        return "Coordinates x:" + this.x + " y:" + this.y;
    }
}
