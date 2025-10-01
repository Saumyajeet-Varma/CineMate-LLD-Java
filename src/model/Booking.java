package model;

import java.util.ArrayList;

public class Booking {
    
    private String id;
    private Customer customer;
    private Screen screen;
    private ArrayList<Seat> bookedSeats;

    public Booking(String id, Customer customer, Screen screen, ArrayList<Seat> seats) {
        this.id = id;
        this.customer = customer;
        this.screen = screen;
        this.bookedSeats = seats;
    }

    public void displayDetails() {

        System.out.println("Booking ID: " + id + ", Customer: " + customer.getName() + ", Screen: " + screen.getId());
        System.out.print("Booked Seats: ");
        
        for (Seat seat : bookedSeats) {
            System.out.print(seat.getSeatNumber() + " ");
        }
        
        System.out.println();
    }

    public void confirmBooking() {

        for (Seat seat : bookedSeats) {
            seat.bookSeat();
        }

        System.out.println("Booking " + id + " confirmed for customer " + customer.getName());
    }
}
