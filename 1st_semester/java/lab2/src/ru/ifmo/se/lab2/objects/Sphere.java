package ru.ifmo.se.lab2.objects;

public class Sphere extends Madeable implements Thinkable{
    public Sphere(Mineable m){
        super(m);
    }

    @Override
    public String toString(){
        return " шар";
    }
}