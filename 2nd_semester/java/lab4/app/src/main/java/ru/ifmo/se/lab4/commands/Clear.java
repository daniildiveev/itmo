package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.entities.Route;

import java.util.PriorityQueue;

public class Clear implements Command{
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "                           -- clear the whole collection\n";
    }

    @Override
    public void execute(PriorityQueue<Route> collection, String[] args) {
        collection.clear();
    }
}
