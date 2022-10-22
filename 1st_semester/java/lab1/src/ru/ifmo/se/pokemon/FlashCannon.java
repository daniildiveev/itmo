package ru.ifmo.se.pokemon;

public class FlashCannon extends SpecialMove{
    public FlashCannon(){
        super(Type.STEEL, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() < 0.1){
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

    @Override
    protected String describe(){
        return "использует FlashCannon";
    }
}