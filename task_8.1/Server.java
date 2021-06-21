//package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        HashMap<Socket, String> clinetSokets = new HashMap<Socket, String>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188); // Создаём серверный сокет
            System.out.println("Сервер запущен");
            while (true){ // бесконечный цикл для ожидания подключения клиентов
                System.out.println("Ожидаю подключения клиентов...");
                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента

                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
                out.writeUTF("Как вас зовут?");

                String name = in.readUTF(); // Принимает сообщение от клиента
                clinetSokets.put(socket,name);
                out.writeUTF("Здравствуйте "+name.toUpperCase(Locale.ROOT)+ " , добро пожаловать в чат!"); // Рассылает принятое сообщение всем клиентам
                out.writeUTF("пишите нам");

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String request = null;
                        while (true){
                            try{
                                request = in.readUTF(); // Принимает сообщение от клиента
                                System.out.println("Клиент прислал: "+request);
                                for (Socket clinetSoket: clinetSokets.keySet()
                                    //  String name: clinetSokets.values()
                                ) { // Перебираем клиентов которые подключенны в настоящий момент
                                    if (clinetSoket != socket) {
                                        DataOutputStream out = new DataOutputStream(clinetSoket.getOutputStream());
                                        out.writeUTF(
                                                "Сообщение от " +
                                                        clinetSokets.get(socket)
                                                        +
                                                        ":"+
                                                        request.toUpperCase(Locale.ROOT)); // Рассылает принятое сообщение всем клиентам
                                    }
                                }
                            }catch (IOException ex){
                                ex.printStackTrace();
                                clinetSokets.remove(socket); // Удаление сокета, когда клиент отключился
                                break;
                            }
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
