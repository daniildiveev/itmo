package ru.ifmo.se.lab4;

import ru.ifmo.se.lab4.commands.Command;
import ru.ifmo.se.lab4.handler.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

class Main{
    public static void main(String [] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CollectionHandler collectionHandler = new CollectionHandler();

        while (true){
            System.out.print("Shell >>");
            String command = reader.readLine();
            command = command.strip();

            CommandHandler.process(command, collectionHandler);
        }
    }
}