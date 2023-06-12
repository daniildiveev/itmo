package common.network;

import common.handler.IOHandler;
import common.validator.UserValidator;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class User implements Serializable {
    private String username;
    private String password;

    public User(){
        Scanner s = new Scanner(System.in);

        IOHandler.print("Username>>");
        username = s.nextLine();

        try {
            UserValidator.validateName(username);
        } catch (Exception e){
            IOHandler.println(e.getMessage());
            return;
        }

        try{
            IOHandler.print("Password>>");
            password = s.nextLine();

            try {
                UserValidator.checkEmptinessOfParameter(password, "password");
            } catch (Exception e){
                IOHandler.println(e.getMessage());
                return;
            }

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] encodedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedPassword) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            password = hexString.toString();

        } catch (NoSuchAlgorithmException e){
            IOHandler.println(e.getMessage());
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
