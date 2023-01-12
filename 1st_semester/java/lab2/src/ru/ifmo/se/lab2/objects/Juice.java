package ru.ifmo.se.lab2.objects;
import ru.ifmo.se.lab2.enums.JuiceParams;

public class Juice implements Gatherable, Carriable{
    private String type;

    @Override
    public String toString(){
        return " сок";
    }

    public String dripOut(){
        return " вытекает";
    }

    public String thicken(){
        return " густеет";
    }

    public String transform(Mineable m){
        return " превращается в" + m.toString();
    }

    public void specifyType(JuiceParams jp){
        switch (jp){
            case WHITE -> this.type = " белый";
            case RUBBER -> this.type = " резиновый";
        }
    }

    public String getType(){
        return this.type;
    }

    @Override
    public int hashCode(){
        String stringToHash = this.getClass().getSimpleName() + this.type;
        return stringToHash.hashCode();
    }

    public boolean equals(Object o){
        if (this.getClass() != o.getClass() || o == null){
            return false;
        }

        Juice j = (Juice) o;

        return j.type == this.type;
    }
}