package ru.ifmo.se.pokemon;

public class IceFang extends PhysicalMove{
    public IceFang(){
        super(Type.ICE, 65, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() < 0.1){
            Effect effect = (new Effect()).condition(Status.FREEZE);
            p.setCondition(effect);
        }
    }

    @Override
    protected String describe(){
        return "использует IceFang";
    } 
}