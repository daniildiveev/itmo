package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.objects.Gatherable;

public class Babies extends Person{
    @Override
    public String toString(){
        return " малышки";
    }

    public String gather(Gatherable g){
        return "собирать " + g.toString();
    }

}