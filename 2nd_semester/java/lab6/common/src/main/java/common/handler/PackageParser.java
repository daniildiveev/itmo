package common.handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import com.google.common.reflect.ClassPath;
import common.commands.Command;

import java.util.stream.Collectors;

public class PackageParser {
    public static Set<Class> parsePackage(String packageName, String[] commandsInterfacesNames) throws IOException {
        ClassPath classpath = ClassPath.from(Thread.currentThread().getContextClassLoader());

        return classpath.getTopLevelClassesRecursive(packageName)
                .stream()
                .map(ClassPath.ClassInfo::load)
                .filter(klass -> !Arrays.asList(commandsInterfacesNames).contains(klass.getSimpleName()))
                .collect(Collectors.toSet());
    }

    public static Command getCommand(String packageName,
                                     String commandName,
                                     String[] commandsInterfacesName){
        try{
            Set<Class> classes = parsePackage(packageName, commandsInterfacesName);

            for (Class klass : classes) {
                try {
                    Command command = (Command) klass.getConstructor().newInstance();

                    if (command.getName().equals(commandName)) {
                        return command;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e){
            IOHandler.println(e.getMessage());
        }

        return null;
    }
}
