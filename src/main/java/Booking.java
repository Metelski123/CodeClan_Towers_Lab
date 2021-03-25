public class Booking {

    private Bedroom bedroom;
    private int nights;
    protected Guest guest;

    public Booking(Guest guest, int nights){
        this.guest = guest;
        this.nights = nights;
    }

    public Guest getGuest(){
        return this.guest;
    }

    public int getNights(){
        return this.nights;
    }
}
