import java.util.ArrayList;

public class DiningRoom extends Room {

    private RoomType roomType;
    private String roomName;
    private ArrayList<Guest> diners;

    public DiningRoom(String roomName, RoomType roomType) {
        super(roomType.getValue());
        this.roomName = roomName;
        this.roomType = roomType;
        this.diners = new ArrayList<Guest>();
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public ArrayList getDiners(){
        return this.diners;
    }
}
