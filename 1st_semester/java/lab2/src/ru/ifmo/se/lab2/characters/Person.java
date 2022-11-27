package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.objects.Carriable;

public class Person{ 
    public String carry(Carriable с){
        return "приносить " + с.toString();
    }

    @Override
    public String toString(){
        return "все ";
    }
}