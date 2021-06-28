package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    DataOutputStream out;
    Socket socket;
    ObjectInputStream in;

    @FXML
    TextField textField;
    @FXML
    TextArea textArea;
    @FXML
    Button connectBtn;
    @FXML
    TextArea userListTextArea;

    @FXML
    private void send() {
        try {
            String text = textField.getText();
            textField.clear();
            textField.requestFocus();
            textArea.appendText(times() + text + "\n");
            out.writeUTF(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void connect() {
        try {
            connectBtn.setText("Отключиться от сервера");
            connectBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    disConnect();
                }
            });
            socket = new Socket("localhost", 8188); // Создаём сокет, для подключения к серверу
            out = new DataOutputStream(socket.getOutputStream()); //выходящий поток
            in = new ObjectInputStream(socket.getInputStream());// входящий объект
            Thread thread = new Thread(new Runnable() { // Создаём поток, для приёма сообщений от сервера
                @Override
                public void run() {
                    String response;
                    while (true) {
                        try {
                            response = in.readObject().toString(); // Принимаем сообщение от сервера
                            System.out.println(response);
                            if (response.startsWith("**userList**")) {
                                String[] usersName = response.split("//"); //**userList**//user1//user2//user3
                                userListTextArea.setText("");
                                for (String name : usersName) {
                                    userListTextArea.appendText(name + "\n");
                                }
                            } else
                                textArea.appendText(response + "\n"); //Печатаем на консоль принятое сообщение от сервера
                        } catch (Exception e) {
                            //e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        } catch (IOException e) {
            // exep.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Сервер не обнаружен, перезапустите приложение!");
            alert.showAndWait();
            System.exit(0);
        }
    }

    @FXML
    private void disConnect () {
        try {
            socket.close();
            out.close();
            in.close();
            out.flush(); // чистим
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String times () {
        Date date;
        String dtime;
        SimpleDateFormat df;
        date = new Date(); // текущая дата
        df = new SimpleDateFormat("HH:mm:ss"); // берем только время до секунд
        dtime = df.format(date); // время
        return dtime = "[" + dtime + "] ";
    }
}