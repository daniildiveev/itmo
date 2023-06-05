package server;

import common.handler.CollectionHandler;
import common.handler.IOHandler;
import server.commands.Save;
import server.network.TCPServer;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("logger");
        CollectionHandler collectionHandler;

        try {
            collectionHandler = new CollectionHandler();
        } catch (Exception e) {
            IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            return;
        }

        TCPServer server = new TCPServer();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.log(Level.INFO, "Shutdown hook invoked. Saving collection to file...");
            System.out.println("Shutdown hook invoked. Saving collection to file...");

            Save saveCommand = new Save();
            saveCommand.save(collectionHandler);
        }));

        try {
            new Thread(() -> server.start(collectionHandler)).start();

            while (true) {
                System.out.print("Server Shell>>");
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();
                String commandName = input.split("\\s+")[0].trim();

                if (commandName.equals("save")) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
