package common.network;

import common.commands.Command;
import common.handler.IOHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class TCPClient {

    private String host = "127.0.0.1";
    private int port = 3333;
    private SocketChannel clientSocket;

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
            InputStream in = new BufferedInputStream(clientSocket.socket().getInputStream());

            objectOutput.writeObject(command);

            String str_in = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            IOHandler.print(str_in);
            in.close();

            objectOutput.close();
            closeConnection();
        }
        return true;
    }

    public ObjectOutputStream getOutputStream() throws IOException{
        return new ObjectOutputStream(this.clientSocket.socket().getOutputStream());
    }
}
