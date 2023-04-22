package client.entities;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Максимальное значение поля: 781, Поле не может быть null

    public Coordinates(Long x, Integer y){
        this.x = x;
        this.y = y;
    }
}
