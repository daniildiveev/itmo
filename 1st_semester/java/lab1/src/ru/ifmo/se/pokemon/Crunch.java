package ru.ifmo.se.pokemon;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Crunch extends PhysicalMove{
    public Crunch(){
        setType(Type.DARK, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if Math.random() <= 0.2{
            p.setMod(Stat.DEFENSE, -1);
        }
    }

    @Override
    protected String describe(){
        return "использует Crunch";
    }
}