package ru.ifmo.se.lab4.entities;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import ru.ifmo.se.lab4.handler.IOHandler;

public class Location{
    private Integer x; //Поле не может быть null
    private float y;
    private double z;
    private String name; //Строка не может быть пустой, Поле не может быть null
    private BufferedReader reader;

    public Location(){
        IOHandler.println("Input now for parameters of Location class..");
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        inputX();
        inputY();
        inputZ();
        inputName();
    }

    private void inputX(){
        IOHandler.println("Please input the x parameter of Location");

        try{
            String input = this.reader.readLine();

            if(input.equals("")){
                IOHandler.println("x parameter cannot be null");
                inputX();
            }

            this.x = Integer.parseInt(input);
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

            if (!input.equals("")){
                this.z = Double.parseDouble(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid y value, please try again...");
            inputY();
        }
    }

    private void inputZ(){
        IOHandler.print("Please input the z parameter of Location");

        try{
            String input = this.reader.readLine();

            if (!input.equals("")){
                this.z = Double.parseDouble(input);
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid z value, please try again...");
            inputZ();
        }
    }

    private void inputName(){
        IOHandler.print("Please input the name parameter of Location");

        try{
            String input = this.reader.readLine();

            if (input.equals("") || input == null){
                this.name = input;
            }
        }

        catch (Exception e){
            IOHandler.println("Invalid name value, please try again...");
            inputName();
        }
    }
}