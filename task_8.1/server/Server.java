package server;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        ArrayList<Socket> clinetSokets = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаёи серверный сокет
            System.out.println("Сервер запущен");
            while (true){ // бесконечный цикл для ожидания подключения клиентов
                System.out.println("Ожидаю подключения клиентов...");
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                User currentUser = new User(socket);
                users.add(currentUser);
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        try {
                            out.writeUTF("Введите имя: ");
                            String userName = in.readUTF();
                            currentUser.setUserName(userName);
                            System.out.println(currentUser.getUserName()+" добро пожаловать на сервер!");
                            out.writeUTF(currentUser.getUserName()+" добро пожаловать на сервер!");
                            while (true){
                                    request = in.readUTF(); // Принимает сообщение от клиента
                                    System.out.println("Клиент прислал: "+request);
                                    for (User user: users) { // Перебираем клиентов которые подключенны в настоящий момент
                                        if(currentUser != user){
                                            DataOutputStream out = new DataOutputStream(user.getSocket().getOutputStream());
                                            out.writeUTF(currentUser.getUserName()+": "+request); // Рассылает принятое сообщение всем клиентам
                                        }
                                    }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            for (User user: users) { // Перебираем клиентов которые подключенны в настоящий момент
                                if(currentUser != user){
                                    try {
                                        DataOutputStream out = new DataOutputStream(user.getSocket().getOutputStream());
                                        out.writeUTF("Пользователь "+currentUser.getUserName()+" покинул чат"); // Рассылает принятое сообщение всем клиентам
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                            }
                            users.remove(currentUser); // Удаление сокета, когда клиент отключился
                        }
                    }
                });
                thread.start();
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
