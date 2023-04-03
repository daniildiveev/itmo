package ru.ifmo.se.lab4.handler;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import ru.ifmo.se.lab4.commands.Command;

import java.util.Set;
import java.util.stream.Collectors;

public class PackageParser {
    public static Set<Class> parsePackage(String packageName, String[] commandsInterfacesNames) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false ));

        return reflections.getSubTypesOf(Object.class)
                .stream()
                .filter(klass -> !klass.getSimpleName().equalsIgnoreCase(commandsInterfacesNames[0]))
                .filter(klass -> !klass.getSimpleName().equalsIgnoreCase(commandsInterfacesNames[1]))
                .collect(Collectors.toSet());
    }

    public static Command getCommand(String packageName,
                                     String commandName,
                                     String[] commandsInterfacesName){
        Set<Class> classes = parsePackage(packageName, commandsInterfacesName);

        for (Class klass: classes){
            try {
                Command command = (Command) klass.getConstructor().newInstance();

                if (command.getName().equals(commandName)) {
                    return command;
                }
            }

            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        return null;
    }
}
