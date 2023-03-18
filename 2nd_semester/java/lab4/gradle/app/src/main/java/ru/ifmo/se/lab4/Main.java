package ru.ifmo.se.lab4;

import ru.ifmo.se.lab4.handler.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(";asjdf;lkajsdf");

        while (true){
            System.out.print("Shell >>");
            String command = reader.readLine();
            System.out.print("Your command: " + command);

            command = command.strip();

            if (command.equals("exit")){
                break;
            }

            CommandHandler.process(command);
        }
    }
}