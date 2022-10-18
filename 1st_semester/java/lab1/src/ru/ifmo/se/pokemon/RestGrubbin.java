package ru.ifmo.se.pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Rest extends StatusMove{
    public Rest(){
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        Effect effect = (new Effect()).condition(Status.SLEEP).attack(0.0).turns(2);
        double regenerated_hp = 47 - p.getHP();
        p.setCondition(effect);
        p.setMod(Stat.HP, regenerated_hp);
    }

    @Override
    protected String describe(){
        return "использует Rest";
    }
}