package common.commands;

import common.entities.Route;
import common.handler.CollectionHandler;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Add extends CommandWithElement {
    @Override
    public String getName(){
        return "add";
    }

    @Override
    public String getDescription(){
        return getName() + "                             -- add new element to collection\n";
    }

    @Override
    public void execute(CollectionHandler collectionHandler){
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        Scanner scanner = new Scanner(System.in);
        String input;
        String[] args = new String[12];

        for(int i=0;i<numStringsToRead;i++){
            input = scanner.nextLine();
            args[i] = input;
        }

        try {
            Route route = new Route(args);
            collection.add(route);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        collectionHandler.updateCollection(collection);
    }
}
