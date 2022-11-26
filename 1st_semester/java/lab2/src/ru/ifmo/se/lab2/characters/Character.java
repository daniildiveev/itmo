package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.objects.*;

public abstract class Character{ 
    public String gather(Gatherable g){
        return "собирать " + g.toString();
    }
}