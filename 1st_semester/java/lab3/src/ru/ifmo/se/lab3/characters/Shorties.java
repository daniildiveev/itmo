package ru.ifmo.se.lab3.characters;
import ru.ifmo.se.lab3.objects.Mineable;

public class Shorties extends Person{
    public String mine(Mineable m){
        return " добывать" + m.toString();
    }

    @Override
    public String toString(){
        return " Коротышки";
    }
}