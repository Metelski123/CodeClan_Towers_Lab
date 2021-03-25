import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void before(){
        guest = new Guest("Jan");
        conferenceRoom = new ConferenceRoom("Meeting", RoomType.CONFERENCE);
    }

    @Test
    public void conferenceRoomHasRoomName(){
        assertEquals("Meeting", conferenceRoom.getRoomName());
    }

    @Test
    public void conferenceRoomHasRoomType() {
        assertEquals(RoomType.CONFERENCE, conferenceRoom.getRoomType());
    }

    @Test
    public void conferenceRoomHasRoomCapacity(){
        assertEquals(20, conferenceRoom.getCapacity());
    }

    @Test
    public void conferenceRoomCurrentCapacityEmpty(){
        assertEquals(20, conferenceRoom.getCurrentCapacity());
    }

    @Test
    public void conferenceRoomCurrentCapacityOccupied(){
        conferenceRoom.addGuestToGuests(guest);
        assertEquals(19, conferenceRoom.getCurrentCapacity());
    }
}
