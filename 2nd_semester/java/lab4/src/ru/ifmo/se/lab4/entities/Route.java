package ru.ifmo.se.lab4.entities;

import java.time.LocalDateTime;
import ru.ifmo.se.lab4.exceptions.*;

public class Route implements Comparable<Route>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1

    public Route(String name, Coordinates coordinates, Location from, Location to, long distance)
        throws Exception{
        //TODO: implement id setting
        if (name == null || name.equals("")){
            throw new InvalidNameException("invalid Route name");
        }

        if (coordinates == null){
            throw new NoCoordinatesException("no coordinates provided");
        }        

        if (from == null || to == null){
            throw new NoLocationException("no location provided");
        }

        if (distance <= 1){
            throw new InvalidDistanceException("invalid distance provided");
        }

        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public int compareTo(Route r){
        return (int) (r.distance - this.distance);        
    }
}