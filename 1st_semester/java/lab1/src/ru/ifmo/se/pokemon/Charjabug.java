package ru.ifmo.se.pokemon;

class Charjabug extends Pokemon{
    public Charjabug(String name, int level){
        super(name, level);
        setStats(57, 82, 95, 55, 75, 36);
        setType(Type.BUG, Type.ELECTRIC);
        setMove(new RestCharjabug(), new Crunch(), new Confide());
    }
}