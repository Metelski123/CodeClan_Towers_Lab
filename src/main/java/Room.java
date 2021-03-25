import java.util.ArrayList;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity){
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getCurrentCapacity(){
        return this.capacity - this.guests.size();
    }

    public ArrayList<Guest> getGuests(){
        return this.guests;
    }

    public void addGuestToGuests(Guest guest){
        this.guests.add(guest);
    }

    public void emptyGuestList() {
        this.guests.clear();
    }

    public void removeGuestFromGuests(Guest guest){
        this.guests.remove(guest);
    }
}
