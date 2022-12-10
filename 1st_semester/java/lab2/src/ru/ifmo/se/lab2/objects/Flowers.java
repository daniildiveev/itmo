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
        if (p == Place.CITY){
            return " В городе росли";
        }

        else {
            return "";
        }
    }

    @Override
    public String toString(){
        return " цветы";
    }

    public String lookALike(){
        return " похожие на фикусы";
    }

    public String makeACut(){
        return " сделать надрез" + stem.toString();
    }
}