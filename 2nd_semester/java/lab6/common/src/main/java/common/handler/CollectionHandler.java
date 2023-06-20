package common.handler;

import common.entities.Route;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class CollectionHandler {
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private final String pathToCollection = System.getenv("LABA5_SOURCE_FILE");
    private PriorityQueue<Route> collection = new PriorityQueue<>();

    public CollectionHandler() throws Exception {
        this.collection = DBHandler.loadCollectionToMemory();
    }

    public String info(){
        String output = "Collection " + this.collection.getClass().getSimpleName();
        output += " containing " + this.collection.size() + " of object Route. \n";
        output += "Collection created on " + dateCreated + ".\n";
        output += "Collection stored at " + pathToCollection + ".\n";

        return output;
    }

    public void updateCollection(PriorityQueue<Route> collection){
        this.collection = collection;
    }
    public PriorityQueue<Route> getCollection() {
        return this.collection;
    }
}
