package ru.ifmo.se.lab3.objects;

public class Barrel implements Preparable{
    public final String SIZE = " большая";

    @Override
    public String toString(){
        return SIZE + " бочка";
    }
}