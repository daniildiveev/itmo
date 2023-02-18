package ru.ifmo.se.lab4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import ru.ifmo.se.lab4.handlers.CommandHandler;

class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.print("Shell >>");
            String command = reader.readLine();

            if (command.equals("exit")){
                break;
            }

            CommandHandler.process(command);
        }
    }
}