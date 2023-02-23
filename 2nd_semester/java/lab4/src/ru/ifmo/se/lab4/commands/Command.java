package ru.ifmo.se.lab4.commands;

public interface Command{
    void getName();
    void getDescription();
    void execute();
}