package ru.ifmo.se.lab2.objects;
import ru.ifmo.se.lab2.enums.JuiceParams;

public class Juice implements Gatherable, Carriable{
    @Override
    public String toString(){
        return "сок ";
    }

    public String dripOut(){
        return " вытекает ";
    }

    public String thickify(){
        return " густеет ";
    }

    public String transform(Mineable m){
        return "превращается в " + m.toString();
    }

    public String specifyType(JuiceParams jp){
        String type = "";
        switch (jp){
            case WHITE -> type = " белый";
            case RUBBER -> type = " резиновый";
        }

        return type;
    }
}