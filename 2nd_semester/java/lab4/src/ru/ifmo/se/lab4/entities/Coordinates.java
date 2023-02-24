package ru.ifmo.se.lab4.entities;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import ru.ifmo.se.lab4.handler.IOHandler;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Максимальное значение поля: 781, Поле не может быть null
    private BufferedReader reader;

    public Coordinates(){
        IOHandler.println("Input now for parameters of Coordinates class..");
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        inputX();
        inputY();
    }

    private void inputX(){
        IOHandler.print("Please input the x parameter of Location");

        try{
            String input = this.reader.readLine();

            if(input.equals("")){
                IOHandler.println("x parameter cannot be null");
                inputX();
            }

            if (this.x == null){
                this.x = Long.parseLong(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid x value, please try again...");
            inputX();
        }
    }

    private void inputY(){
        IOHandler.print("Please input the y parameter of Location");

        try{
            String input = this.reader.readLine();

            if(input.equals("") || Integer.parseInt(input) >= 781){
                IOHandler.println("y parameter cannot be null or greater than 781");
                inputY();
            }

            if (this.y == null){
                this.y = Integer.parseInt(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid y value, please try again...");
            inputY();
        }
    }
}