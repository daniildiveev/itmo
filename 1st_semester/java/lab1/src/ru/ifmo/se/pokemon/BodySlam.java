package ru.ifmo.se.pokemon;

public class BodySlam extends PhysicalMove{
    public BodySlam(){
        super(Type.NORMAL, 85, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() < 0.3){
            Effect effect = (new Effect()).condition(Status.PARALYZE);
            p.setCondition(effect);
        }
    }

    @Override
    protected String describe(){
        return "использует BodySlam";
    }
}