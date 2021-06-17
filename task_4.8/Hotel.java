public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {

        this.rooms = rooms;
    }

    public void getFreeRooms(){
        String freeRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) freeRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера свободных комнат "+freeRoomsList);
    }
    public void reserveRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(false);
                info = ("Комната номер "+roomNumber+" успешно забронированна");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" занята";
                break;
            }
        }

        System.out.println(info);
    }
}