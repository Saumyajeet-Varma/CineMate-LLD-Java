import java.util.ArrayList;

public class Customer {
    
    private String id;
    private String name;
    private ArrayList<Booking> bookings;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings found for " + name);
        } 
        else {
            System.out.println("Bookings for " + name + ":");

            for (Booking booking : bookings) {
                booking.displayDetails();
            }
        }
    }
}
