package ru.ifmo.se.lab2.objects;

public class Boots extends Madeable{
    public Boots(Mineable m){
        super(m);
    }

    @Override
    public String toString(){
        return " калоши";
    }
}