package ru.ifmo.se.pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Pokemon;

public class AirSlash extends SpecialMove{
    public AirSlash(){
        super(Type.FLYING, 75, 90);
    }

    @Override
    protected String describe(){
        return "использует AirSlash";
    }
}