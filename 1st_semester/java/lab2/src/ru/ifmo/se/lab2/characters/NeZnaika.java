package ru.ifmo.se.lab2.characters;
import ru.ifmo.se.lab2.enums.Place;

public class NeZnaika extends Person{
    @Override
    public String toString(){
        return " НеЗнайка";
    }

    public String meet(Person p, Place where){
        if (where == Place.STREET){
            return "на улице встретил" + p.toString();
        }

        else{
            return "";
        }
    }
}