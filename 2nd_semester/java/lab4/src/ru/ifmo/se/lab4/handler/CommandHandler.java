package ru.ifmo.se.lab4.handler;

import ru.ifmo.se.lab4.entities;

public class CommandHandler{
    public static void process(String  command){
        String[] args = command.split("\\s+");

        switch(args[0]){
            case "help" -> {
                String output;

                output =  "help                            -- show information about available commands \n";
                output += "info                            -- show information about collection (type, initialization date, number of elements)\n";
                output += "show                            -- show all elements of collection in String representation\n";
                output += "add {element}                   -- add new element to collection\n";
                output += "update id {element}             -- update collection element with respect to id\n";
                output += "remove_by_id id                 -- remove element with respect to id\n";
                output += "clear                           -- clear the whole collection\n";
                output += "save                            -- save collection to file\n";
                output += "execute_script file_name        -- read and execute script from provided file\n";
                output += "exit                            -- exit application without saving\n";
                output += "remove_first                    -- remove first element from collection\n";
                output += "remove_greater {element}        -- remove all elements from collection that is greater than given\n";
                output += "remove_lower {element}          -- remove all elements from collection that is less than given\n";
                output += "remove_any_by_distance distance -- remove any element from collection which distance is equal to the given\n";
                output += "count_by_distance distance      -- count all elements from collection which distance is equal to the given\n";
                output += "print_unique_distance           -- show unique distances";

                System.out.println(output);
            }

            case "info" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "add" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "update" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "remove_by_id" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }
            
            case "clear" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "save" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "execute_script" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "remove_first" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "remove_greater" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "remove_lower" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "remove_any_by_distance" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "count_by_distance" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            case "print_unique_distance" -> {
                //TODO implement
                System.out.println("Not implemented yet");
            }

            default -> System.out.println("Invalid command provided");
        }
    }
}