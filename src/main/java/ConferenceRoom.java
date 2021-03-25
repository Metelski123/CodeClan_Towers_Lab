public class ConferenceRoom extends Room{

    private String roomName;
    private RoomType roomType;

    public ConferenceRoom(String roomName, RoomType roomType){
        super(roomType.getValue());
        this.roomName = roomName;
        this.roomType = roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}
