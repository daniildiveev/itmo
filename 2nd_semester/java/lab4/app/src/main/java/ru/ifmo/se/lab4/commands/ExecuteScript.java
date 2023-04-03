package ru.ifmo.se.lab4.commands;

import ru.ifmo.se.lab4.handler.CollectionHandler;
import ru.ifmo.se.lab4.handler.CommandHandler;
import ru.ifmo.se.lab4.handler.FileHandler;
import ru.ifmo.se.lab4.handler.IOHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExecuteScript implements Command{
    private static final List<String> handledScripts = new ArrayList<>();

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return getName() + " file_name        -- read and execute script from provided file\n";
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
                File file = FileHandler.process(scriptName);

                if (file != null){
                    FileInputStream fis = new FileInputStream(scriptName);
                    InputStreamReader isr = new InputStreamReader(fis);
                    handledScripts.add(scriptName);

                    int data = isr.read();

                    while(data != -1){
                        tmpCommandsInFile += (char) data;
                        data = isr.read();
                    }

                    if (tmpCommandsInFile.equals("")){
                        IOHandler.println("File is empty");
                        return;
                    }
                }

                else{
                    handledScripts.remove(scriptName);
                    return;
                }
            }
            catch (IOException e){
                IOHandler.println(e.getMessage());
            }
            finally {
                commandsInFile = tmpCommandsInFile;
            }

            for(String rawInput: commandsInFile.split("\n")) {
                CommandHandler.process(rawInput, collectionHandler, true);
            }

            handledScripts.remove(scriptName);
        }
        catch (ArrayIndexOutOfBoundsException e){
            IOHandler.println("no script name provided");
        }
    }
}
