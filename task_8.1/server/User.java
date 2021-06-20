package server;

import java.net.Socket;
import java.util.UUID;

public class User {
    private Socket socket;
    private String userName;
    private UUID uuid;

    public User(Socket socket) {
        this.socket = socket;
        this.userName = "Гость";
        this.uuid = UUID.randomUUID();
    }

    public void setUserName(String userName) { this.userName = userName; }
    public Socket getSocket() { return socket;}
    public String getUserName() { return userName;}
    public UUID getUuid() { return uuid; }
}