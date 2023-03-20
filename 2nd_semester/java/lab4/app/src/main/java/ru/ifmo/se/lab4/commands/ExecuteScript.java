package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.CommandHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExecuteScript implements Command{
    private static List<String> handledScripts = new ArrayList<>();

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return getName() + "";
    }

    @Override
    public void execute(CollectionHandler collectionHandler, String[] args){
        String commandsInFile, tmpCommandsInFile = "";

        try{
            String scriptName = args[1];

            if (handledScripts.contains(scriptName)){
                IOHandler.println("Script cannot call itself or have infinite loop");
                return;
            }

            try {
                FileInputStream fis = new FileInputStream(scriptName);
                handledScripts.add(scriptName);

                int i;

                while ((i=fis.read()) != -1){
                    tmpCommandsInFile += (char) i;
                }

                if (tmpCommandsInFile.equals("")){
                    IOHandler.println("File is empty");
                    return;
                }
            }
            catch (IOException e){
                IOHandler.println(e.getMessage());
            }
            finally {
                commandsInFile = tmpCommandsInFile;
            }

            for(String rawInput: commandsInFile.split("\n")){
                CommandHandler.process(rawInput, collectionHandler);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            IOHandler.println("no script name provided");
        }
    }
}
