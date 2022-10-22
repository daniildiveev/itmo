package ru.ifmo.se.pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;

class Vikavolt extends Pokemon{
    public Vikavolt(String name, int level){
        super(name, level);
        setStats(77, 70, 90, 145, 75, 43);
        setType(Type.BUG, Type.ELECTRIC);
        setMove(new Confide(), new Crunch(), new RestVikavolt(), new AirSlash());
    }
}