package main.java.com.cinemate.model;

import java.util.ArrayList;

public class Screen {
    
    private String id;
    private Movie movie;
    private ArrayList<Seat> seats;

    public Screen(String id, int totalSeats) {

        this.id = id;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat("S" + i));
        }
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getId() {
        return id;
    }

    public void displaySeats() {

        System.out.println("Seats in Screen " + id + ":");

        for (Seat seat : seats) {
            System.out.print(seat.getSeatNumber() + (seat.isBooked() ? "[X] " : "[O] "));
        }

        System.out.println();
    }

    public Seat getSeat(String seatNumber) {

        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }

        return null;
    }
}
