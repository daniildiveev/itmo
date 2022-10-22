package ru.ifmo.se.pokemon;

public class RestCharjabug extends StatusMove{
    public RestCharjabug(){
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        Effect effect = (new Effect()).condition(Status.SLEEP).attack(0.0).turns(2);
        p.setCondition(effect);
        p.setStats(57, 82, 95, 55, 75, 36);
    }

    @Override
    protected String describe(){
        return "использует Rest";
    }
}