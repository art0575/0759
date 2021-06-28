package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<User> users;

    public static void main(String[] args) {
        users = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаёи серверный сокет
            System.out.println("Сервер запущен");
            while (true) { // бесконечный цикл для ожидания подключения клиентов
                System.out.println("Ожидаю подключения клиентов...");
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                User currentUser = new User(socket);
                users.add(currentUser);
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); // Поток вывода
                currentUser.setOos(oos);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        try {
                            currentUser.getOos().writeObject("Как вас зовут?");
                            currentUser.setUserName(in.readUTF());
                            sendUserList();
                            currentUser.getOos().writeObject("Добро пожаловать! " + currentUser.getUserName());
                            while (true) {
                                request = in.readUTF(); // Принимает сообщение от клиента
                                System.out.println("Клиент прислал: " + request);
                                for (User user : users) { // Перебираем клиентов которые подключенны в настоящий момент
                                    if (!user.getUserName().equals(currentUser.getUserName())) {
                                        user.getOos().writeObject(currentUser.getUserName() + ": ");
                                        user.getOos().writeObject(request); // Рассылает принятое сообщение всем клиентам
                                    }
                                }
                            }
                        } catch (IOException ex) {
                            try {
                                currentUser.getSocket().close();
                                System.out.println("Сокет закрыт");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            users.remove(currentUser); // Удаление сокета, когда клиент отключился
                            for (User user : users) { // Перебираем клиентов которые подключенны в настоящий момент
                                if (!user.getUserName().equals(currentUser.getUserName())) {
                                    try {
                                        user.getOos().writeObject("Пользователь " + currentUser.getUserName() + " покинул чат");

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            sendUserList();

                        }
                    }
                });
                thread.start();
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void sendUserList() {
        String userName = "**userList**";
        for (User user : users) {
            userName += "//" + user.getUserName();
        }
        for (User user : users
        ) {
            try {
                user.getOos().writeObject(userName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

