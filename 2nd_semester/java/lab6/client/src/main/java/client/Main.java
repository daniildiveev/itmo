package client;

import common.commands.Command;
import common.commands.authentication.AuthenticationCommand;
import common.commands.collection.CollectionCommand;
import common.commands.collection.CommandWithElement;
import common.commands.collection.ExecuteScript;
import common.commands.collection.Exit;
import common.entities.Route;
import common.exceptions.*;
import common.handler.CommandHandler;
import common.handler.IOHandler;
import common.network.TCPClient;
import common.network.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TCPClient client = new TCPClient();

        while(true){
            System.out.print("Shell>>");
            String input = scanner.nextLine();

            try {
                Command command = CommandHandler.process(input);

                if((command instanceof CollectionCommand) && client.getUser() != null){
                    if (command instanceof Exit) System.exit(0);

                    if (command instanceof CommandWithElement) {
                        Route r = new Route();
                        ((CommandWithElement) command).setRoute(r);
                        ((CommandWithElement) command).setUser(client.getUser());
                    }

                    if (command instanceof ExecuteScript) {
                        ((ExecuteScript) command).retrieveCommands(client);

                    } else {
                        client.sendRequest(command);
                    }
                } else if (command instanceof AuthenticationCommand){
                    ((AuthenticationCommand) command).setUser(new User());
                    client.sendRequest(command);
                } else {
                    throw new NotLoggedInException("not logged in yet");
                }
            } catch (InvalidCommandNameException|IOException e){
                IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            } catch (NotLoggedInException e){
                IOHandler.println("You haven't logged in yet! Type login or register!");
            }
        }
    }
}
