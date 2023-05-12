package client;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.commands.CommandWithElement;
import common.commands.ExecuteScript;
import common.entities.Route;
import org.apache.log4j.PropertyConfigurator;

import common.exceptions.InvalidCommandNameException;
import common.handler.IOHandler;
import client.network.TCPClient;
import common.commands.Command;
import common.handler.CommandHandler;

public class Main {
    public static void main(String[] args) {
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
        Logger logger = Logger.getLogger("logger");

        Scanner scanner = new Scanner(System.in);
        TCPClient client = new TCPClient();

        System.out.println("ЗАПУСКАЕМ\n" +
                "░ГУСЯ░▄▀▀▀▄░РАБОТЯГИ░░\n" +
                "▄███▀░◐░░░▌░░░░░░░\n" +
                "░░░░▌░░░░░▐░░░░░░░\n" +
                "░░░░▐░░░░░▐░░░░░░░\n" +
                "░░░░▌░░░░░▐▄▄░░░░░\n" +
                "░░░░▌░░░░▄▀▒▒▀▀▀▀▄\n" +
                "░░░▐░░░░▐▒▒▒▒▒▒▒▒▀▀▄\n" +
                "░░░▐░░░░▐▄▒▒▒▒▒▒▒▒▒▒▀▄\n" +
                "░░░░▀▄░░░░▀▄▒▒▒▒▒▒▒▒▒▒▀▄\n" +
                "░░░░░░▀▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▀▄\n" +
                "░░░░░░░░░░░▌▌▌▌░░░░░\n" +
                "░░░░░░░░░░░▌▌░▌▌░░░░░\n" +
                "░░░░░░░░░▄▄▌▌▄▌▌░░░░░\n" +
                "запускаем гуся работяги");

        while(true){
            System.out.print("Shell>>");
            String input = scanner.nextLine();

            if(input.split("\\s+")[0].trim().equals("exit")){
                System.exit(0);
            }

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
            } catch (InvalidCommandNameException|IOException e){
                IOHandler.println(e.getMessage());
            }
        }
    }
}
