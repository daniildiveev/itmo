package ru.ifmo.se.lab2.objects;
import ru.ifmo.se.lab2.enums.Place;

public class Flowers{
    class Stem{
        @Override
        public String toString(){
            return " стебель";
        }
    }

    final Stem stem = new Stem(); 

    public String grow(Place p){
        String output;

        switch (p){
            case CITY -> output = " В городе росли";
            default -> output = "";
        }

        return output;
    }

    @Override
    public String toString(){
        return " цветы";
    }

    public String lookALike(){
        return toString() + " похожие на фикусы";
    }

    public String makeACut(){
        return " сделать надрез" + stem.toString();
    }
}