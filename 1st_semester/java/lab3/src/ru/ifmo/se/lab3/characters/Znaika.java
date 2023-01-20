package ru.ifmo.se.lab3.characters;
import ru.ifmo.se.lab3.enums.PartOfDay;
import ru.ifmo.se.lab3.objects.*;

public class Znaika extends Person implements PersonWhoCanSpeak{
    public class Barrel{
        public final String SIZE = " большая";

        @Override
        public String toString(){
            return SIZE + " бочка";
        }
    } //non-static nested class

    private Barrel barrel;

    public Znaika(){
        this.barrel = new Barrel();
    }

    public String think(PartOfDay p, int howLong){
        String output = toString() + " думал ";

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
        return toString() + " придумал" + t.toString();
    }

    public String tell(Person p){
        return toString() + " велел" + p.toString();
    }

    public String thinkOver(){
        return toString() + " обдумает";
    }

    public String explain(){
        return toString() + " объяснит";
    }

    public String prepareBarrel(){
        return toString() + " приготовил" + this.barrel.toString();
    }
}