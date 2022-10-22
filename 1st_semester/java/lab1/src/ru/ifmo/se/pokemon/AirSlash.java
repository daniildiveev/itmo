package ru.ifmo.se.pokemon;

public class AirSlash extends SpecialMove{
    public AirSlash(){
        super(Type.FLYING, 75, 90);
    }

    @Override
    protected String describe(){
        return "использует AirSlash";
    }
}