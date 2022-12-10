package ru.ifmo.se.lab2.objects;

public abstract class Madeable{
    public static String material;

    public Madeable(Mineable m){
        material = m.toString();    
    }

    public String getMaterial(){
        return " из" + material;
    }

    public String canBeMadeOutOf(){
        return " можно сделать" + toString();
    }
} 