package model;

public class Seat {
    
    private String seatNumber;
    private boolean isBooked;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat() {

        if (!isBooked) {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " is booked successfully.");
        } 
        else {
            System.out.println("Seat " + seatNumber + " is already booked.");
        }
    }

    public void cancelBooking() {
        
        if (isBooked) {
            isBooked = false;
            System.out.println("Booking for seat " + seatNumber + " is cancelled.");
        } 
        else {
            System.out.println("Seat " + seatNumber + " is not booked.");
        }
    }
}
