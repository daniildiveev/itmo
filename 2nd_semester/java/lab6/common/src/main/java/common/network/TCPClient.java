package common.network;


import common.commands.Command;
import common.commands.authentication.AuthenticationCommand;
import common.commands.collection.CollectionCommand;
import common.handler.IOHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

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

    public boolean sendRequest(Command command) throws IOException {
        if(connectToServer()){
            ObjectOutput objectOutput = new ObjectOutputStream(this.clientSocket.socket().getOutputStream());

            Request request = new Request(command, this.user);
            objectOutput.writeObject(request);

            try{
                if(request.getCommand() instanceof AuthenticationCommand){
                    ObjectInput objectInput = new ObjectInputStream(this.clientSocket.socket().getInputStream());

                    Response response = (Response) objectInput.readObject();

                    if (response.getCode() != 201){
                        IOHandler.println("Authentication error");
                    } else {
                        this.user = response.getUser();
                        IOHandler.println("Authentication successful");
                    }

                    if (response.getOutput() != null) {
                        IOHandler.println(response.getOutput());
                    }
                } else if (request.getCommand() instanceof CollectionCommand){
                    InputStream in = new BufferedInputStream(clientSocket.socket().getInputStream());

                    String strIn = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                    IOHandler.print(strIn);
                    in.close();
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
