package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.objects.*;

public class Shorties extends Character{
    public String mine(Mineable m){
        return "добывать " + m.toString();
    }

    public String gather(Gatherable g){
        return "собирать " + g.toString();
    }

    @Override
    public String toString(){
        return "Коротышки ";
    }
}