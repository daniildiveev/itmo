package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface CommandWithElement extends Command{
    void executeFromFile(CollectionHandler collectionHandler, String[] args);
    default void validateArgs(List<String> args){
        if(args.toArray().length != 12){
            IOHandler.println("Invalid amount of arguments for creating Route");
            return;
        }
    }

    default List<String> parseRoute(String argsString){
        List<String> routeArgs = new ArrayList<>();

        String[] regexes = new String[]{"Name\\s?:\\s?(\\S*)",
                                        "Coordinates\\s?:\\s?(\\S*)\\s(\\S*)\\s",
                                        "From\\s?:\\s?(\\S*)\\s(\\S*)\\s(\\S*)\\s(\\S*)\\s",
                                        "To\\s?:\\s?(\\S*)\\s(\\S*)\\s(\\S*)\\s(\\S*)\\s",
                                        "Distance\\s?:\\s?(\\S*)"
                                        };

        for (String regex: regexes){
            Matcher m = Pattern.compile(regex).matcher(argsString);

            if (m.find()){
                for(int i=1;i<m.groupCount()+1;i++){
                        routeArgs.add(m.group(i));
                }
            }
        }

        return routeArgs;
    }
}
