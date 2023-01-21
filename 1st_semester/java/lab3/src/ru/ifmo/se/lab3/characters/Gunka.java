package ru.ifmo.se.lab3.characters;
import ru.ifmo.se.lab3.exceptions.AmountOfPlayersException;

public class Gunka extends PersonWithEmotions implements PersonWhoCanSpeak{
    @Override
    public String toString(){
        return " Гунька";
    }

    public String playPrigalki(Person p, int amountOfPlayers) throws AmountOfPlayersException{
        if (amountOfPlayers < 1){
            throw new AmountOfPlayersException("not enough players!");
        }
        return toString() + " играть в прыгалки с " + Integer.toString(amountOfPlayers) + p.toString();
    }

    public String toShowOff(){
        return toString() + " захотелось похвастаться";
    }
}