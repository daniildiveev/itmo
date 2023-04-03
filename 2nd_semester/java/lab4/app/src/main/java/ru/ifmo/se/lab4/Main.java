package ru.ifmo.se.lab4;

import org.apache.log4j.BasicConfigurator;
import ru.ifmo.se.lab4.handler.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String [] args) throws Exception{
        BasicConfigurator.configure();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CollectionHandler collectionHandler = new CollectionHandler();

        while (true){
            System.out.print("Shell >>");
            String command = reader.readLine();
            command = command.strip();

            CommandHandler.process(command, collectionHandler, false);;
        }
    }
}