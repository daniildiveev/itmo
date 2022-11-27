package ru.ifmo.se.lab2.objects;

public class Ball extends Sphere{
    public Ball(Mineable m){
        super(m);
    }

    @Override
    public String toString(){
        return "мяч ";
    }
}