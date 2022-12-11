package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.enums.PartOfDay;
import ru.ifmo.se.lab2.objects.*;

public class Znaika extends Person{
    public String think(PartOfDay p, int howLong){
        String output = " думал ";

        if (howLong != 0){
            output = output + Integer.toString(howLong);

            switch (p) {
            case NIGHT -> output = output + " ночи ";
            case DAY -> output = output + " дня "; 
            }
        }

        return output;
    }

    @Override
    public String toString(){
        return " Знайка";
    }

    public String getTheIdea(Thinkable t){
        return " придумал" + t.toString();
    }

    public String tell(Person p){
        return " велел" + p.toString();
    }

    public String prepare(Preparable p){
        return " приготовил" + p.toString();
    }
}