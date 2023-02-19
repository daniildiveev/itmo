package ru.ifmo.se.lab4.entities;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Location{
    private Integer x; //Поле не может быть null
    private float y;
    private double z;
    private String name; //Строка не может быть пустой, Поле не может быть null
    private BufferedReader reader;

    public Location(){
        System.out.println("Input now for parameters of Location class..");
        BufferedReader this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private void inputX(){
        System.out.println("Please input the x parameter of Location");

        try{
            String input = this.reader.readLine();

            if(input == null){
                System.out.println("x parameter cannot be null");
                inputX();
            }

            this.x = Integer.parseInt(input);
        }

        catch (Exception e){
            System.out.println("Invalid x value, please try again...");
            inputX();
        }
    }
}