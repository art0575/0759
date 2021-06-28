package server;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

public class User {
    private Socket socket;
    private String userName;
    private UUID uuid;
    private ObjectOutputStream oos;

    public ObjectOutputStream getOos() { return oos; }

    public void setOos(ObjectOutputStream oos) { this.oos = oos;
    }

    public User(Socket socket) {
        this.socket = socket;
        this.userName = "Гость";
        this.uuid = UUID.randomUUID();
    }

    public Socket getSocket() { return socket; }
    public String getUserName() { return userName; }
    public UUID getUuid() { return uuid; }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
