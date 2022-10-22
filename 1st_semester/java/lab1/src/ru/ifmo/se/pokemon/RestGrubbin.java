package ru.ifmo.se.pokemon;

public class RestGrubbin extends StatusMove{
    public RestGrubbin(){
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        Effect effect = (new Effect()).condition(Status.SLEEP).attack(0.0).turns(2);
        p.setCondition(effect);
        p.setStats(47, 62, 45, 55, 45, 46);
    }

    @Override
    protected String describe(){
        return "использует Rest";
    }
}