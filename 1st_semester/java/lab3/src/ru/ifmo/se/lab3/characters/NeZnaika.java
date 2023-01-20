package ru.ifmo.se.lab3.characters;
import ru.ifmo.se.lab3.enums.Place;
import ru.ifmo.se.lab3.objects.Gatherable;

public class NeZnaika extends Person{
    @Override
    public String toString(){
        return " НеЗнайка";
    }

    public String meet(Person p, Place where){
        String output = toString() + " встретил" + p.toString();

        switch(where){
            case STREET -> output += " на улице";
            default -> output += "";
        }

        return output;
    }

    public String gather(Gatherable g){
        return toString() + " тоже пошел собирать" + g.toString();
    }
}