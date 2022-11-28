package ru.ifmo.se.lab2.objects;

public class Juice implements Gatherable, Carriable{
    @Override
    public String toString(){
        return "сок ";
    }

    public String dripOut(){
        return " вытекает ";
    }

    public String thickify(){
        return " густеет ";
    }

    public String transform(Mineable m){
        return "превращается в " + m.toString();
    }
}