package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.handler.CollectionHandler;

public interface Command{
    String getName();
    String getDescription();
    void execute(CollectionHandler collectionHandler, String[] args);
}