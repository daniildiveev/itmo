package server.network;

import common.handler.CollectionHandler;
import common.commands.Command;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
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
            //logger.log(Level.INFO,"Ожидание подключения...");
            try{
                boolean noConnection = true;

                while(noConnection){
                    try{
                        this.clientSocket = serverSocketChannel.accept();
                        noConnection = false;
                    } catch (IOException e){}
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
            logger.log(Level.SEVERE,"Ошибка при открытии соединения", e.getMessage());
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

        Command command = (Command) objectInput.readObject();
        command.execute(collectionHandler, in);

        in.close();
        objectInput.close();
        return true;
    }

    public Socket getClientSocket(){
        return clientSocket.socket();
    }
}
