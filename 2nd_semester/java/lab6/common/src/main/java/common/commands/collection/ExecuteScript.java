package common.commands.collection;

import common.entities.Route;
import common.exceptions.InvalidCommandNameException;
import common.handler.CommandHandler;
import common.handler.FileHandler;
import common.handler.IOHandler;
import common.network.TCPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExecuteScript extends CollectionCommand {
    private static final List<String> handledScripts = new ArrayList<>();

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return getName() + " file_name        -- read and execute script from provided file";
    }

    public void retrieveCommands(TCPClient client) {
        List<CollectionCommand> commands = new ArrayList<>();

        try {
            String scriptName = this.args[0];

            if (handledScripts.contains(scriptName)) {
                IOHandler.println("Script cannot call itself or have infinite loop");
                return;
            }

            try {
                File file = FileHandler.process(scriptName);

                if (file != null) {
                    FileInputStream fis = new FileInputStream(scriptName);
                    InputStreamReader isr = new InputStreamReader(fis);
                    handledScripts.add(scriptName);

                    Scanner scanner = new Scanner(isr);
                    String rawInput;

                    while (scanner.hasNextLine()) {
                        rawInput = scanner.nextLine();

                        try {
                            CollectionCommand command = CommandHandler.process(rawInput);

                            if (command instanceof CommandWithElement) {
                                String[] routeArgs = new String[CommandWithElement.getNumStringsToRead()];

                                boolean ok = true;

                                for (int i = 0; i < CommandWithElement.getNumStringsToRead(); i++) {
                                    if (i < CommandWithElement.getNumStringsToRead() - 1 && !scanner.hasNextLine()) {
                                        ok = false;
                                        break;
                                    } else {
                                        routeArgs[i] = scanner.nextLine();
                                    }
                                }

                                if (ok) {
                                    try {
                                        Route r = new Route(routeArgs);
                                        System.out.println("Sending command" + command.getName());
                                        ((CommandWithElement) command).setRoute(r);
                                        client.sendRequest(command);
                                    } catch (Exception e) {
                                        IOHandler.println(e.getMessage());
                                    }
                                }
                            } else {
                                if (command instanceof ExecuteScript) {
                                    ((ExecuteScript) command).retrieveCommands(client);
                                } else {
                                    System.out.println("Sending command" + command.getName());
                                    client.sendRequest(command);
                                }
                            }
                        } catch (InvalidCommandNameException e) {
                            IOHandler.println("Skipping command " + rawInput + " since it is not present in package");
                        }
                    }
                } else {
                    handledScripts.remove(scriptName);
                    return;
                }
            } catch (IOException e) {
                IOHandler.println(e.getMessage());
            }

            handledScripts.remove(scriptName);
        } catch (ArrayIndexOutOfBoundsException e) {
            IOHandler.println("no script name provided");
        }
    }
}
