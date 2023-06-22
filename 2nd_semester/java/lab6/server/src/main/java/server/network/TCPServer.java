package server.network;

import common.handler.CollectionHandler;
import common.commands.Command;
import common.handler.IOHandler;
import common.network.Response;
import common.threading.RequestExecutor;
import common.threading.ResponseQueueOutput;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer{
    private ServerSocketChannel serverSocketChannel;
    private final int port = 3333;
    protected SocketChannel clientSocket;
    private final Logger logger = Logger.getLogger("logger");
    private final int numberOfThreads = 10;
    private final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(numberOfThreads);
    private final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    BlockingQueue<Command> commandQueue = new LinkedBlockingQueue<>();
    BlockingQueue<Response>  responseQueue = new LinkedBlockingQueue<>();

    public void start(CollectionHandler collectionHandler){
        openServerSocket();

        while(serverSocketChannel!=null){
                boolean noConnection = true;

                while(noConnection){
                    try{
                        this.clientSocket = serverSocketChannel.accept();
                        noConnection = false;

                        new Thread(new RequestHandler(this.clientSocket, this.commandQueue)).start();
                        RequestExecutor requestExecutor = new RequestExecutor(this.commandQueue, this.responseQueue, collectionHandler);
                        fixedThreadPool.submit(requestExecutor);
                        collectionHandler = requestExecutor.getCollectionHandler();
                        cachedThreadPool.submit(new ResponseQueueOutput(this.responseQueue, this.clientSocket.socket()));

                    } catch (IOException e){
                        System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
                    }
                }

                logger.log(Level.INFO, "Подключение успешно");
        }

        closeServerSocket();
    }

    private void openServerSocket() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", port));
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Ошибка при открытии соединения" + e.getMessage(), e.getMessage());
        }
    }

    private void closeServerSocket() {
        try {
            serverSocketChannel.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Ошибка при закрытии соединения", e.getMessage());
        }
    }

    private static class RequestHandler implements Runnable{
        private SocketChannel clientSocket;
        BlockingQueue requestQueue;


        public RequestHandler(SocketChannel clientSocket,
                              BlockingQueue<Command> blockingQueue){
            this.clientSocket = clientSocket;
            this.requestQueue = blockingQueue;
        }

        private boolean processRequest() throws IOException, ClassNotFoundException {
            ObjectInput objectInput = new ObjectInputStream(this.clientSocket.socket().getInputStream());
            Command command = (Command) objectInput.readObject();

            try{
                requestQueue.put(command);
            } catch (InterruptedException e){
                IOHandler.println("Request handling execution interrupted: " + e.getMessage());
            }

            return true;
        }

        @Override
        public void run() {
            try {
                processRequest();
            } catch (Exception e){
                IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}
