package common.entities;

import common.exceptions.InvalidParameterValueException;
import common.handler.IOHandler;
import common.validator.RouteValidator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Route implements Comparable<Route>, Serializable {
    private static final List<Integer> usedIds  = new ArrayList<>();
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1

    public Route(String[] args) throws Exception{
        RouteValidator.validate(args);

        this.id = generateValidId();
        usedIds.add(this.id);

        this.name = args[0];
        this.coordinates = new Coordinates(Long.parseLong(args[1]),
                                            Integer.parseInt(args[2]));

        this.creationDate = LocalDateTime.now();

        this.from = new Location(Integer.parseInt(args[3]),
                                 Float.parseFloat(args[4]),
                                 Double.parseDouble(args[5]),
                                 args[6]);

        this.to = new Location(Integer.parseInt(args[7]),
                                 Float.parseFloat(args[8]),
                                 Double.parseDouble(args[9]),
                                 args[10]);

        this.distance = Long.parseLong(args[11]);
    }

    public Route(){
        Scanner s = new Scanner(System.in);
        this.id = generateValidId();
        usedIds.add(this.id);

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

    private int generateValidId(){
        Collections.sort(usedIds);
        int i = 1;

        while(usedIds.contains(i)){
            i++;
        }

        return i;
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

    public int getId(){
        return this.id;
    }

    public static void removeId(int id){
        usedIds.remove(id);
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

        return output;
    }

    @Override
    public int compareTo(Route r){
        return Long.compare(r.getDistance(), this.distance);
    }
}
