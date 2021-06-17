import java.util.Scanner;

/*
*  ***Гостиница***
*  1) Гостиница
*  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
*
*   *Задание для лабораторной работы №4*
*   Освободить комнату
*   Вывести свойства комнаты
*   Показать комнаты с WiFi
*   Показать комнаты с WC
*   Показать комнаты с Eat
*   Показать комнаты по кол-ву спальных мест
*   Отобразить список команд
* */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,true,(byte) 11),
                new Room((byte) 2,true,true,false,(byte) 12),
                new Room((byte) 1,false,true,true,(byte) 13),
                new Room((byte) 3,true,false,false,(byte) 21),
                new Room((byte) 2,false,false,false,(byte) 22),
                new Room((byte) 1,true,true,true,(byte) 23),
                new Room((byte) 3,false,true,false,(byte) 31),
                new Room((byte) 3,true,true,false,(byte) 32),
                new Room((byte) 1,false,false,true,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите команду: ");
            command = scanner.next();
            if(command.equals("ShowRooms")){
                hotel.showRooms();
            }else if(command.equals("ShowFreeRooms")) {
                hotel.showFreeRooms();
            }else if(command.equals("ShowRoomsWC")){
                hotel.showRoomsWC();
            }else if(command.equals("ShowRoomsEat")){
                hotel.showRoomsEat();
            }else if(command.equals("ShowRoomsWF")){
                hotel.showRoomsWF();
            }else if(command.equals("ReserveRoom")){
                System.out.print("Введите номер комнаты для бронирования: ");
                byte roomNumber = scanner.nextByte();
                hotel.reserveRoom(roomNumber);
            }else if(command.equals("ReleaseRoom")) {
                System.out.println("Введите номер освобождаемой комнаты: ");
                byte roomNumber = scanner.nextByte();
                hotel.releaseRoom(roomNumber);
            }else if(command.equals("ShowRoom")) {
                System.out.println("Какую комнату отобразить подробно: ");
                byte roomNumber = scanner.nextByte();
                hotel.showRoom(roomNumber);
            }else if(command.equals("ShowBedsRooms")) {
                System.out.println("Для скольких человек нужна комната (1-3): ");
                byte beds = scanner.nextByte();
                hotel.ShowBedsRooms(beds);
            }else if (command.equals("Help") || command.equals("help")){
                System.out.println("Доступные команды: ShowRooms, ShowRoom, ShowFreeRooms, ShowRoomsWC, ShowRoomsEat, ShowRoomsWF, ReserveRoom, ReleaseRoom, ShowBedsRooms, Help, Exit");}
            else if (command.equals("Exit") || command.equals("exit")){break;}
            else System.out.println("Неизвестная команда. Список команд - help");
            scanner.reset(); // чтобы очистить буфер ввода строки
        }

    }
}