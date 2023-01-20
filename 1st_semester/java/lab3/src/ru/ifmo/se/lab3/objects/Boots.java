package ru.ifmo.se.lab3.objects;

public class Boots extends Madeable implements Thinkable{
    public Boots(Mineable m){
        super(m);
    }

    @Override
    public String toString(){
        return " калоши";
    }
}