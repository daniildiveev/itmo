package server.network;

import common.commands.authentication.AuthenticationCommand;
import common.commands.collection.CollectionCommand;
import common.handler.CollectionHandler;
import common.commands.Command;
import common.network.Request;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer{
    private ServerSocketChannel serverSocketChannel;
    private int port = 3333;
    protected SocketChannel clientSocket;
    private Logger logger = Logger.getLogger("logger");

    public void start(CollectionHandler collectionHandler){
        openServerSocket();

        while(serverSocketChannel!=null){
            try{
                boolean noConnection = true;

                while(noConnection){
                    try{
                        this.clientSocket = serverSocketChannel.accept();
                        noConnection = false;
                    } catch (IOException e){
                        System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
                    }
                }

                logger.log(Level.INFO, "Подключение успешно");
                processRequest(collectionHandler);
            } catch (IOException ioe) {
                logger.log(Level.SEVERE,"Не удалось подключиться к клиенту: " + ioe.getMessage(), ioe.getMessage());
            } catch (ClassNotFoundException ioe) {
                logger.log(Level.SEVERE, "Ошибка в полученном запросе: " + ioe.getMessage(), ioe.getMessage());
            }
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

    private boolean processRequest(CollectionHandler collectionHandler) throws IOException, ClassNotFoundException {
        ObjectInput objectInput = new ObjectInputStream(this.clientSocket.socket().getInputStream());
        PrintWriter in = new PrintWriter(this.clientSocket.socket().getOutputStream(), true);
        ObjectOutput objectOutput = new ObjectOutputStream(this.clientSocket.socket().getOutputStream());

        Request request = (Request) objectInput.readObject();
        Command command = request.getCommand();

        if(command instanceof CollectionCommand){
            ((CollectionCommand) command).execute(collectionHandler, in);
        } else if (command instanceof AuthenticationCommand){
            ((AuthenticationCommand) command).execute(objectOutput);
        }

        in.close();
        objectInput.close();
        return true;
    }

    public Socket getClientSocket(){
        return clientSocket.socket();
    }
}
