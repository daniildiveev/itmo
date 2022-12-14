package ru.ifmo.se.lab2.objects;
import ru.ifmo.se.lab2.enums.Place;

public class Flowers{
    private String growPlace;

    class Stem{
        @Override
        public String toString(){
            return " стебель";
        }
    }

    final Stem stem = new Stem(); 

    public void grow(Place p){
        switch (p){
            case CITY -> this.growPlace = " В городе росли";
            default -> this.growPlace = "";
        }
    }

    public String getGrowPlace(){
        return this.growPlace;
    }

    @Override
    public int hashCode(){
        return this.growPlace.hashCode();
    }

    @Override
    public boolean equals(Flowers f){
        return f.hashCode() == hashCode();
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