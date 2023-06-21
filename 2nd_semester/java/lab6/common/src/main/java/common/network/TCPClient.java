package common.network;


import common.commands.Command;
import common.commands.collection.CollectionCommand;
import common.handler.IOHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class TCPClient {
    private String host = "127.0.0.1";
    private int port = 3333;
    private SocketChannel clientSocket;
    private User user = null;

    public boolean connectToServer() {
        try {
            this.clientSocket = SocketChannel.open(new InetSocketAddress(host, port));
            return true;
        } catch (IOException ioe) {
            IOHandler.println("Ошибка при подключении: " + ioe.getMessage());
            return false;
        }
    }

    public void closeConnection() throws IOException {
        this.clientSocket.close();
    }

    public boolean sendRequest(Command command) throws  IOException{
        if(connectToServer()){
            ObjectOutput objectOutput = new ObjectOutputStream(this.clientSocket.socket().getOutputStream());

            if (command instanceof CollectionCommand){
                command.setUser(this.user);
            }

            objectOutput.writeObject(command);

            try{
                ObjectInput objectInput = new ObjectInputStream(this.clientSocket.socket().getInputStream());
                Response response = (Response) objectInput.readObject();

                if (this.user == null){
                    this.user = response.getUser();
                }

                if(response.getOutput() != null){
                    IOHandler.println(response.getOutput());
                }
            } catch (ClassNotFoundException e){
                IOHandler.println(e.getMessage());
            } finally {
                objectOutput.close();
                closeConnection();
            }
        }
        return true;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
