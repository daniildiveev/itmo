package common.handler;

import common.entities.Route;

import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CollectionHandler {
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private final String pathToCollection = System.getenv("LABA5_SOURCE_FILE");
    private PriorityQueue<Route> collection = new PriorityQueue<>();
    private ReadWriteLock collectionLock = new ReentrantReadWriteLock();

    public CollectionHandler() throws Exception {
        this.collection = DBHandler.loadCollectionToMemory();
    }

    public String info(){
        collectionLock.readLock().lock();

        try{
            String output = "Collection " + this.collection.getClass().getSimpleName();
            output += " containing " + this.collection.size() + " of object Route. \n";
            output += "Collection created on " + dateCreated + ".\n";
            output += "Collection stored at " + pathToCollection + ".\n";

            return output;
        } finally {
            collectionLock.readLock().unlock();
        }
    }

    public void updateCollection(PriorityQueue<Route> collection){
        collectionLock.writeLock().lock();

        try{
            this.collection = collection;
        } finally {
            collectionLock.writeLock().unlock();
        }

    }
    public PriorityQueue<Route> getCollection() {
        collectionLock.readLock().lock();

        try{
            return this.collection;
        } finally {
            collectionLock.readLock().unlock();
        }
    }
}
