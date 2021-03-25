import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;

    public Hotel() {
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.diningRooms = new ArrayList<DiningRoom>();
    }

    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public int getBedrooms() {
        return bedrooms.size();
    }

    public int getConferenceRooms() {
        return conferenceRooms.size();
    }

    public int getAllRooms() {
        return bedrooms.size() + conferenceRooms.size();
    }

//    public void checkInBedroom(Guest guest, Bedroom bedroom){
//        bedroom.addGuestToGuests(guest);
//    }

    public void checkInBedroom(Booking booking, Bedroom bedroom){
        if(bedroom.getCurrentCapacity() == bedroom.getCapacity()){
            bedroom.addGuestToGuests(booking.getGuest());
        }
    }

    public void checkInConferenceRoom(Guest guest, ConferenceRoom conferenceRoom){
        conferenceRoom.addGuestToGuests(guest);
    }

    public void checkOutBedroom(Bedroom bedroom) {
        bedroom.emptyGuestList();
    }

    public void checkOutConferenceRoom(ConferenceRoom conferenceRoom) {
        conferenceRoom.emptyGuestList();
    }

    public Booking makeBooking(Guest guest, int nights){
        Booking booking = new Booking(guest, nights);
        return booking;
    }

    public int createInvoice(Booking booking, Bedroom bedroom) {
        return booking.getNights() * bedroom.roomType.getRate();
    }

    public void addDiningRoom(DiningRoom diningRoom){
        diningRooms.add(diningRoom);
    }

    public void tableSeated(Guest guest, DiningRoom diningRoom) {
        diningRoom.addGuestToGuests(guest);
    }

    public void clearTable(Guest guest, DiningRoom diningRoom) {
        diningRoom.removeGuestFromGuests(guest);
    }

    public int numberOfEmptyRooms(){
        int counter = 0;
        for (Bedroom bedroom : this.bedrooms){
            if (bedroom.getCurrentCapacity() == bedroom.getCapacity()){
                counter++;
            }
        }
        return counter;
    }
}
