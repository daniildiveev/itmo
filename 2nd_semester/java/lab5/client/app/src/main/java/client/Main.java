package client;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.commands.CommandWithElement;
import common.commands.ExecuteScript;
import common.commands.Exit;
import common.entities.Route;
import org.apache.log4j.PropertyConfigurator;

import common.exceptions.InvalidCommandNameException;
import common.handler.IOHandler;
import client.network.TCPClient;
import common.commands.Command;
import common.handler.CommandHandler;

public class Main {
    public static void main(String[] args) {
        //PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
        Logger logger = Logger.getLogger("logger");

        Scanner scanner = new Scanner(System.in);
        TCPClient client = new TCPClient();

        while(true){
            System.out.print("Shell>>");
            String input = scanner.nextLine();

            try {
                Command command = CommandHandler.process(input);

                if(command instanceof CommandWithElement){
                    Route r = new Route();
                    ((CommandWithElement) command).setRoute(r);
                }

                if(command instanceof ExecuteScript){
                    List<Command> commands = ((ExecuteScript) command).retrieveCommands();

                    if (commands != null){
                            commands.forEach(commandObject -> {
                                try{
                                    client.sendRequest(commandObject);
                                } catch (IOException e){
                                    logger.log(Level.SEVERE, "Problem when sending data to server: " + e.getMessage(), e.getMessage());
                            }
                        });
                    } else {
                        IOHandler.println("Could not read commands from file");
                    }
                } else {
                    client.sendRequest(command);
                }

                if (command instanceof Exit) System.exit(0);
            } catch (InvalidCommandNameException|IOException e){
                IOHandler.println(e.getMessage());
            }
        }
    }
}
