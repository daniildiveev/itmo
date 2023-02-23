package ru.ifmo.se.lab4.commands;

public interface Command{
    String getName();
    String getDescription();
    void execute();
}