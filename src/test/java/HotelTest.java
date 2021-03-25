import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom;
    Bedroom bedroom2;
    Bedroom bedroom3;
    Bedroom bedroom4;
    ConferenceRoom conferenceRoom;
    Guest guest;
    Guest guest2;

    @Before
    public void before(){
        bedroom = new Bedroom(1, RoomType.SINGLE);
        bedroom2 = new Bedroom(2, RoomType.DOUBLE);
        bedroom3 = new Bedroom(3, RoomType.TRIPLE);
        bedroom4 = new Bedroom(4, RoomType.FAMILY);
        conferenceRoom = new ConferenceRoom("Ballroom", RoomType.CONFERENCE);
        guest = new Guest("Jan");
        guest2 = new Guest("Simon");
        hotel = new Hotel();
    }

    @Test
    public void hotelHasBedroom(){
        hotel.addBedroom(bedroom);
        assertEquals(1, hotel.getBedrooms());
    }

    @Test
    public void hotelHasConferenceRoom(){
        hotel.addConferenceRoom(conferenceRoom);
        assertEquals(1, hotel.getConferenceRooms());
    }

    @Test
    public void hotelHasConferenceRoomAndBedroom(){
        hotel.addBedroom(bedroom);
        hotel.addConferenceRoom(conferenceRoom);
        assertEquals(2, hotel.getAllRooms());
    }

    @Test
    public void hotelCanCheckGuestIntoBedRoom(){
        hotel.addBedroom(bedroom);
        Booking booking = hotel.makeBooking(guest, 5);
        hotel.checkInBedroom(booking, bedroom);
        assertEquals(0, bedroom.getCurrentCapacity());
    }

    @Test
    public void hotelCanCheckGuestIntoMeetingRoom(){
        hotel.addConferenceRoom(conferenceRoom);
        hotel.checkInConferenceRoom(guest, conferenceRoom);
        assertEquals(19, conferenceRoom.getCurrentCapacity());
    }

    @Test
    public void hotelCanCheckGuestOutBedRoom() {
        hotel.addBedroom(bedroom);
        Booking booking = hotel.makeBooking(guest, 5);
        hotel.checkInBedroom(booking, bedroom);
        hotel.checkOutBedroom(bedroom);
        assertEquals(1, bedroom.getCurrentCapacity());
    }

    @Test
    public void hotelCanCheckGuestOutConferenceRoom() {
        hotel.addConferenceRoom(conferenceRoom);
        hotel.checkInConferenceRoom(guest, conferenceRoom);
        hotel.checkOutConferenceRoom(conferenceRoom);
        assertEquals(20, conferenceRoom.getCurrentCapacity());
    }

    @Test
    public void hotelCanMakeBooking(){
        Booking booking = hotel.makeBooking(guest, 5);
//        Guest guest = booking.getGuest();
//        assertEquals("Jan", guest.getGuestName());
        assertEquals("Jan", booking.getGuest().getGuestName());
    }

    @Test
    public void bookingHasRate(){
        Booking booking = hotel.makeBooking(guest, 5);
        hotel.checkInBedroom(booking, bedroom);
        assertEquals(500, hotel.createInvoice(booking, bedroom));
    }

    @Test
    public void dinerHasGuest() {
        DiningRoom diner = new DiningRoom("Diner", RoomType.DINING);
        hotel.addDiningRoom(diner);
        hotel.tableSeated(guest, diner);
        assertEquals(29, diner.getCurrentCapacity());
    }

    @Test
    public void dinerHasNoGuest() {
        DiningRoom diner = new DiningRoom("Diner", RoomType.DINING);
        hotel.addDiningRoom(diner);
        hotel.tableSeated(guest, diner);
        hotel.clearTable(guest, diner);
        assertEquals(30, diner.getCurrentCapacity());
    }

    @Test
    public void hotelHasEmptyBedrooms(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.addBedroom(bedroom4);
        Booking booking = hotel.makeBooking(guest, 5);
        hotel.checkInBedroom(booking, bedroom2);
        int actual = hotel.numberOfEmptyRooms();
        assertEquals(3, actual);
    }

    @Test
    public void cannotCheckInIntoOccupiedRoom(){
        hotel.addBedroom(bedroom);
        Booking booking = hotel.makeBooking(guest, 5);
        Booking booking2 = hotel.makeBooking(guest2, 5);
        hotel.checkInBedroom(booking, bedroom);
        assertEquals("Jan", bedroom.getGuests().get(0).getGuestName());
        hotel.checkInBedroom(booking2, bedroom);
        assertEquals(1, bedroom.getGuests().size());
        assertEquals("Jan", bedroom.getGuests().get(0).getGuestName());
    }
}
