import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;

    @Before
    public void before(){
        guest = new Guest("Jan");
        bedroom = new Bedroom(1, RoomType.SINGLE);
    }

    @Test
    public void bedroomHasRoomNumber(){
        assertEquals(1, bedroom.getRoomNumber());
    }

    @Test
    public void bedroomHasRoomType() {
        assertEquals(RoomType.SINGLE, bedroom.getRoomType());
    }

    @Test
    public void bedroomHasRoomCapacity(){
        assertEquals(1, bedroom.getCapacity());
    }

    @Test
    public void bedroomCurrentCapacityEmpty(){
        assertEquals(1, bedroom.getCurrentCapacity());
    }

    @Test
    public void bedroomCurrentCapacityOccupied(){
        bedroom.addGuestToGuests(guest);
        assertEquals(0, bedroom.getCurrentCapacity());
    }


}
