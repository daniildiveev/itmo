package ru.ifmo.se.lab3.objects;
import ru.ifmo.se.lab3.characters.Person;

public abstract class Madeable{
    private String material;

    public Madeable(Mineable m){
        this.material = m.toString();    
    }

    public String getMaterial(){
        return " из" + this.material;
    }

    public String canBeMadeOutOf(){
        return " можно сделать" + toString();
    }

    public String nobodyKnewHowToMake(){
        Person nobody = new Person(){
            @Override
            public String toString(){
                return " Никто";
            }
        }; //anonymous class

        return nobody.toString() + " не знал как сделать" + toString();
    }

    @Override
    public int hashCode(){
        String stringToHash = this.getClass().getSimpleName() + this.material;
        return stringToHash.hashCode();
    }

    @Override 
    public boolean equals(Object o){
        if (this.getClass() != o.getClass() || o == null){
            return false;
        }

        Madeable m = (Madeable) o;

        return m.material == this.material;
    }
} 