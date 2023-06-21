package common.threading;

import common.handler.IOHandler;
import common.network.Response;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class ResponseQueueOutput implements Runnable{
    BlockingQueue<Response> responseQueue;
    private Socket clientSocket;
    private Response response;

    public ResponseQueueOutput(BlockingQueue<Response> responseQueue, Socket socket){
        this.responseQueue = responseQueue;
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try{
            this.response = responseQueue.take();

            if(!this.clientSocket.isClosed()){
                ObjectOutput out = new ObjectOutputStream(this.clientSocket.getOutputStream());
                out.writeObject(this.response);
                out.flush();
            }
        } catch (Exception e){
            IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
