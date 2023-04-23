package common.entities;

import common.validator.RouteValidator;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Route implements Comparable<Route>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1

    public Route(String[] args) throws Exception{
        RouteValidator.validate(args);

        this.name = args[0];
        this.coordinates = new Coordinates(Long.parseLong(args[1]),
                                            Integer.parseInt(args[2]));

        this.creationDate = LocalDateTime.now();

        this.from = new Location(Integer.parseInt(args[3]),
                                 Float.parseFloat(args[4]),
                                 Double.parseDouble(args[5]),
                                 args[6]);

        this.from = new Location(Integer.parseInt(args[7]),
                                 Float.parseFloat(args[8]),
                                 Double.parseDouble(args[9]),
                                 args[10]);

        this.distance = Long.parseLong(args[11]);
    }

    public void setId(int id){
        this.id = id;
    }

    public long getDistance(){
        return this.distance;
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

    @Override
    public int compareTo(Route r){
        return Long.compare(r.getDistance(), this.distance);
    }
}
