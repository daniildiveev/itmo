package ru.ifmo.se.lab3.characters;
import ru.ifmo.se.lab3.objects.*;

public class Person{ 
    public String carry(Carriable с){
        return toString() + " приносить" + с.toString();
    }

    @Override
    public String toString(){
        return " все";
    }

    @Override
    public int hashCode(){
        String stringToHash = this.getClass().getSimpleName();
        return stringToHash.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (this.getClass() != o.getClass() || o == null){
            return false;
        }
        return true;
    }

    public String like(Likeable l){
        return l.toString() + " понравилось" + toString();
    }

    public String notToKnow(){
        return toString() + " не знал";
    }
}