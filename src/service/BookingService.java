package service;

import model.*;

import java.util.ArrayList;

public class BookingService {
    
    public Booking createBooking(String bookingId, Customer customer, Screen screen, ArrayList<String> seatNumbers) {
        
        ArrayList<Seat> selectedSeats = new ArrayList<>();

        for(String seatNumber: seatNumbers) {
            
            Seat seat = screen.getSeat(seatNumber);

            if(seat != null && !seat.isBooked()) {
                selectedSeats.add(seat);
            } 
            else {
                System.out.println("Seat " + seatNumber + " is not available.");
            }
        }

        if(selectedSeats.isEmpty()) {
            System.out.println("No seats available for booking.");
            return null;
        }

        Booking booking = new Booking(bookingId, customer, screen, selectedSeats);
        booking.confirmBooking();
        customer.addBooking(booking);

        return booking;
    }
}
