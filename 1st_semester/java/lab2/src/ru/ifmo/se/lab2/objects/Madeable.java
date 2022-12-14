package ru.ifmo.se.lab2.objects;

public abstract class Madeable{
    private String material;

    public Madeable(Mineable m){
        this.material = m.toString();    
    }

    public String getMaterial(){
        return " из" + this.material;
    }

    public String canBeMadeOutOf(){
        return " можно сделать" + toString();
    }
} 