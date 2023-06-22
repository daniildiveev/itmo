package common.threading;

import common.commands.Command;
import common.commands.authentication.AuthenticationCommand;
import common.handler.CollectionHandler;
import common.handler.IOHandler;
import common.network.Response;

import java.util.concurrent.BlockingQueue;

public class RequestExecutor implements Runnable{
    private final BlockingQueue<Command> requestQueue;
    private final BlockingQueue<Response> responseQueue;
    private final CollectionHandler collectionHandler;

    public RequestExecutor(BlockingQueue<Command> blockingQueue,
                           BlockingQueue<Response> responseQueue,
                           CollectionHandler collectionHandler){
        this.requestQueue = blockingQueue;
        this.responseQueue = responseQueue;
        this.collectionHandler = collectionHandler;
    }

    @Override
    public void run() {
        Command command;

        try {
            command = this.requestQueue.take();
            Response response = command.execute(this.collectionHandler);
            responseQueue.put(response);
        } catch (Throwable e) {
            IOHandler.println(e.getClass() + ": " + e.getMessage());
        }
    }

    public CollectionHandler getCollectionHandler() {
        return collectionHandler;
    }
}
