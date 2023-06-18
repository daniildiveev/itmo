package common.network;

import java.io.Serializable;

public class Response implements Serializable {
    private int code;
    private String output = null;

    private User user;

    public Response(int code, String output, User user){
        this.code = code;
        this.output = output;
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public String getOutput() {
        return output;
    }

    public User getUser() {
        return user;
    }
}
