package ru.ifmo.se.lab4.handler;

import java.time.LocalDateTime;

public class CollectionHandler {
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private String pathToCollection = System.getenv("LABA5_SOURCE_FILE");

    public CollectionHandler(){}
}
