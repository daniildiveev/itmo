package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.handler.CollectionHandler;

public interface CommandWithElement extends Command{
    void executeFromFile(CollectionHandler collectionHandler, String[] args);
}
