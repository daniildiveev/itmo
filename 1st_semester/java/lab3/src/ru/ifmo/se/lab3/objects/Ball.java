package ru.ifmo.se.lab3.objects;

public class Ball extends Sphere{
    public Ball(Mineable m){
        super(m);
    }

    @Override
    public String toString(){
        return " мяч";
    }
}