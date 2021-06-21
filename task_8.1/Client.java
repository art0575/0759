//package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static boolean alive = true;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8188); // Создаём сокет, для подключения к серверу
            System.out.println("Успешно подключен");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Thread thread = new Thread(new Runnable() { // Создаём поток, для приёма сообщений от сервера
                @Override
                public void run() {
                    String response = null;
                    while (true){
                        try {
                            response = in.readUTF(); // Принимаем сообщение от сервера
                            System.out.println("Сервер прислал сообщение: "+response); //Печатаем на консоль принятое сообщение от сервера
                        } catch (IOException e) {
                            e.printStackTrace();
                            alive = false;
                            System.exit(0);
                            break;
                        }
                    }
                }
            });
            thread.start();
            Scanner scanner = new Scanner(System.in);
            String request = null;
            while (alive){
                request = scanner.nextLine(); // Ждём сообщение от пользователя (из консоли)
                out.writeUTF(request); // Отправляем сообщение из консоли на сервер
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}