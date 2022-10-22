package ru.ifmo.se.pokemon;

public class RestVikavolt extends StatusMove{
    public RestVikavolt(){
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        Effect effect = (new Effect()).condition(Status.SLEEP).attack(0.0).turns(2);
        p.setCondition(effect);
        p.setStats(77, 70, 90, 145, 75, 43);
    }

    @Override
    protected String describe(){
        return "использует Rest";
    }
}