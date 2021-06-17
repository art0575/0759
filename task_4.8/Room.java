/*
* 2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 */
public class Room {
    private byte beds;
    private boolean wc;
    private boolean eat;
    private boolean wifi;
    private boolean isFree;
    private byte roomNumber;

    public Room(byte beds, boolean wc, boolean eat, boolean wifi,byte roomNumber) {
        this.beds = beds;
        this.wc = wc;
        this.eat = eat;
        this.wifi = wifi;
        this.isFree = true;
        this.roomNumber = roomNumber;
    }


    public byte getRoomNumber() {
        return roomNumber;
    }

    public byte getBeds() {
        return beds;
    }

    public boolean isWc() {
        return wc;
    }

    public boolean isEat() {
        return eat;
    }

    public boolean isWifi() {
        return wifi;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}