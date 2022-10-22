package ru.ifmo.se.pokemon;

class Terrakion extends Pokemon{
    public Terrakion(String name, int level){
        super(name, level);
        setStats(91, 129, 90, 72, 90, 108);
        setType(Type.ROCK, Type.FIGHTING);
    }
}