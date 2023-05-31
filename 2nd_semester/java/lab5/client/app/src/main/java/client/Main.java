package client;

import common.commands.Command;
import common.commands.CommandWithElement;
import common.commands.ExecuteScript;
import common.commands.Exit;
import common.entities.Route;
import common.exceptions.InvalidCommandNameException;
import common.handler.CommandHandler;
import common.handler.IOHandler;
import common.network.TCPClient;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("logger");

        Scanner scanner = new Scanner(System.in);
        TCPClient client = new TCPClient();

        while(true){
            System.out.print("Shell>>");
            String input = scanner.nextLine();

            try {
                Command command = CommandHandler.process(input);

                if (command instanceof Exit) System.exit(0);

                if(command instanceof CommandWithElement){
                    Route r = new Route();
                    ((CommandWithElement) command).setRoute(r);
                }

                if(command instanceof ExecuteScript){
                    ((ExecuteScript) command).retrieveCommands(client);

                } else {
                    client.sendRequest(command);
                }
            } catch (InvalidCommandNameException|IOException e){
                IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}
