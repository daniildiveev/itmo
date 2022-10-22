package ru.ifmo.se.pokemon;

class Avalugg extends Pokemon{
    public Avalugg(String name, int level){
        super(name, level);
        setStats(95, 117, 184, 44, 46, 28);
        setType(Type.ICE);
    }
}