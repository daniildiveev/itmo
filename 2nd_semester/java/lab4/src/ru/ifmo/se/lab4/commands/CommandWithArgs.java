package ru.ifmo.se.lab4.commands;

public interface CommandWithArgs extends Command{
    void getArgs(String[] args);
}