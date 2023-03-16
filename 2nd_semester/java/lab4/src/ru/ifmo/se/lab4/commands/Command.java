package ru.ifmo.se.lab4.commands;

import java.util.PriorityQueue;
import ru.ifmo.se.lab4.entities.Route;

public interface Command{
    String getName();
    String getDescription();
    void execute(PriorityQueue<Route> collection, String[] args);
}