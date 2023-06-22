package common.entities;

import common.exceptions.InvalidParameterValueException;
import common.handler.IOHandler;
import common.network.User;
import common.validator.RouteValidator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Route implements Comparable<Route>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1
    private String user;

    public Route(int id,
                 String name,
                 Long coordinatesX,
                 Integer coordinatesY,
                 LocalDateTime creationDate,
                 Integer fromX,
                 Float fromY,
                 Double fromZ,
                 String fromName,
                 Integer toX,
                 Float toY,
                 Double toZ,
                 String toName,
                 long distance,
                 String username) throws Exception{
        RouteValidator.validateParams(id,
                name, coordinatesX, coordinatesY,
                fromX, fromName, toX, toName, distance);

        this.id = id;
        this.name = name;
        this.coordinates = new Coordinates(coordinatesX, coordinatesY);
        this.creationDate = creationDate;
        this.from = new Location(fromX, fromY, fromZ, fromName);
        this.to = new Location(toX, toY, toZ, toName);
        this.distance = distance;
        this.user = username;
    }

    public Route(String[] args) throws Exception{
        RouteValidator.validate(args);

        this.name = args[0];
        this.coordinates = new Coordinates(Long.parseLong(args[1]),
                                            Integer.parseInt(args[2]));

        Float locationY;
        Double locationZ;

        try{
            locationY = Float.parseFloat(args[4]);
        } catch (NumberFormatException e){
            locationY = null;
        }

        try{
            locationZ = Double.parseDouble(args[5]);
        } catch (NumberFormatException e){
            locationZ = null;
        }

        this.from = new Location(Integer.parseInt(args[3]),
                                 locationY,
                                 locationZ,
                                 args[6]);

        try{
            locationY = Float.parseFloat(args[8]);
        } catch (NumberFormatException e){
            locationY = null;
        }

        try{
            locationZ = Double.parseDouble(args[9]);
        } catch (NumberFormatException e){
            locationZ = null;
        }

        this.to = new Location(Integer.parseInt(args[7]),
                                 locationY,
                                 locationZ,
                                 args[10]);

        this.distance = Long.parseLong(args[11]);
    }

    public Route(){
        Scanner s = new Scanner(System.in);

        inputName(s);

        this.coordinates = new Coordinates();
        this.to = new Location();
        this.from = new Location();
        this.creationDate = LocalDateTime.now();

        inputDistance(s);
    }

    private void inputName(Scanner s){
        IOHandler.print("Please input the name parameter of Route >>");

        try{
            String input = s.nextLine();

            if (input == null || input.isEmpty()){
                throw new InvalidParameterValueException("name parameter cannot be null");
            }

            if (this.name == null){
                this.name = input;
            }
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid name value, please try again...");
            inputName(s);
        }
    }

    private void inputDistance(Scanner s){
        IOHandler.print("Please input the distance parameter of Route >>");

        try{
            String input = s.nextLine();

            if (Long.parseLong(input) <= 1){
                throw new InvalidParameterValueException("distance must be greater than 1");
            }

            this.distance = Long.parseLong(input);
        }

        catch (Exception e){
            IOHandler.println(e.getMessage());
            IOHandler.println("Invalid distance provided, please try again...");
            inputDistance(s);
        }
    }

    public void setId(int id){
        this.id = id;
    }

    public long getDistance(){
        return this.distance;
    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public String getUser() {
        return user;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setUser(User user) {
        this.user = user.getUsername();
    }

    public void setCreationDate(LocalDateTime timestamp){
        this.creationDate = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) return false;
        if(o == this) return true;

        Route route = (Route) o;

        return Objects.equals(this.name, route.getName()) && this.coordinates.equals(route.getCoordinates()) &&
                this.from.equals(route.getFrom()) && this.to.equals(route.getTo()) && Objects.equals(this.distance, route.getDistance());
    }

    @Override
    public int hashCode() {
        return ("@" + this.getClass().getSimpleName() + this.name + this.coordinates.hashCode()
                + this.to.hashCode() + this.from.hashCode() + this.distance).hashCode();
    }

    @Override
    public String toString(){
        String output = "Route: " + this.id + "\n";
        output += "Name: " + this.name + "\n";
        output += this.coordinates.toString() + "\n";
        output += "Date: " + this.creationDate + "\n";
        output += "From " + this.from.toString() + "\n";
        output += "To" + this.to.toString() + "\n";
        output += "Distance: " + this.distance;
        output += "\n";

        return output;
    }

    @Override
    public int compareTo(Route r){
        return Long.compare(r.getDistance(), this.distance);
    }
}
