package ru.ifmo.se.lab3.characters;

public interface PersonWhoCanSpeak{
    default String say(){
        return toString() + " сказал что";
    }
}