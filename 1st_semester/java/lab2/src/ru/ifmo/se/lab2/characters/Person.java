package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.objects.Carriable;

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
    public boolean equals(Person p){
        return hashCode() == p.hashCode();
    }
}