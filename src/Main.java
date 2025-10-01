import model.*;
import service.*;

import java.util.*;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);

    private static Screen findScreen(Theater theater, String screenId) {

        for(Screen screen : theater.getScreens()) {
            if(screenId.equals(screen.getMovie().getId()) || screenId.equals(screen.getId())) {
                return screen;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Theater theater = new Theater("Cinemate", "Bhubaneswar");

        Movie movie1 = new Movie("M001", "Inception", "Sci-Fi", 148);
        Movie movie2 = new Movie("M002", "The Dark Knight", "Action", 152);

        Screen screen1 = new Screen("S001", 10);
        Screen screen2 = new Screen("S002", 15);

        screen1.setMovie(movie1);
        screen2.setMovie(movie2);

        theater.addScreen(screen1);
        theater.addScreen(screen2);

        Customer customer = new Customer("C001", "Samm");

        BookingService bookingService = new BookingService();

        boolean exit = false;
        while(!exit) {

            System.out.println("1. Show Movies");
            System.out.println("2. Show Seats for a Screen");
            System.out.println("3. Book Tickets");
            System.out.println("4. View My Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
            
                case 1:
                    theater.showMovies();
                    break;
                
                case 2:
                    System.out.print("Enter Screen ID (S001/S002): ");
                    String screenId = scanner.nextLine();

                    Screen selectedScreen = findScreen(theater, screenId);

                    if(selectedScreen != null) {
                        selectedScreen.displaySeats();
                    } 
                    else {
                        System.out.println("Screen not found.");
                    }

                    break;
                
                case 3:
                    System.out.print("Enter Screen ID (S001/S002): ");
                    screenId = scanner.nextLine();
                    
                    selectedScreen = findScreen(theater, screenId);

                    if(selectedScreen == null) {
                        System.out.println("Screen not found.");
                        break;
                    }

                    selectedScreen.displaySeats();

                    System.out.println("Enter seat numbers to book (comma separated, e.g., S001,S002): ");
                    
                    String[] seatArray = scanner.nextLine().split(",");
                    ArrayList<String> seatNumbers = new ArrayList<>();

                    for(String seat : seatArray) {
                        seatNumbers.add(seat.trim());
                    }

                    String bookingId = UUID.randomUUID().toString();
                    bookingService.createBooking(bookingId, customer, selectedScreen, seatNumbers);
                    
                    break;
                
                case 4:
                    customer.viewBookings();
                    break;
                
                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using Cinemate!");
    }
}
