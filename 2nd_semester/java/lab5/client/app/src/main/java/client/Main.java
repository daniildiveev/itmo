package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import client.network.TCPClient;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TCPClient client = new TCPClient();
        client.sendData();
    }
}
