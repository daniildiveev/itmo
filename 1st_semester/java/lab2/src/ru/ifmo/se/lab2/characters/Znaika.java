package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.enums.PartOfDay;
import ru.ifmo.se.lab2.objects.Madeable;

public class Znaika extends Character{
    public String think(PartOfDay p, int howLong){
        String output = "думал ";

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
        return "Знайка ";
    }

    public String getTheIdea(Madeable m){
        return "придумал " + m.toString() + m.getMaterial();
    }
}