package ru.ifmo.se.lab3.objects;

public class Aerostat extends Sphere implements Flyable{
    public Aerostat(Mineable m){
        super(m);
    }

    @Override
    public String toString(){
        return " Воздушный шар";
    }
}