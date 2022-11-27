package ru.ifmo.se.lab2.characters;

public class NeZnaika extends Person{
    @Override
    public String toString(){
        return " НеЗнайка";
    }

    public String meet(Person p){
        return " встретил" + p.toString();
    }
}