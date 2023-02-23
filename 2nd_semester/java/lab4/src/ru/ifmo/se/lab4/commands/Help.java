package ru.ifmo.se.lab4.commands;

public class Help implements Command{
    public String getName(){
        return "help";
    }

    public String getDescription(){
        return getName() + " -- show information about available commands";
    }

    public void execute(){
        System.out.println("Not implemented yet");
    }
}