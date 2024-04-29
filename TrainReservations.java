package trainreservations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainReservations {
    public static void main(String[] args) {
        System.out.println("Welcome to the Train Ticket Booking System!");

        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Exit");

            // Get user choice
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bookTicket(sc);
                    break;
                case 2:
                    System.out.println("Please book a ticket first.");
                    break;
                case 3:
                    System.out.println("Thank you for using the Train Ticket Booking System. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
    }

    private static void bookTicket(Scanner scanner) {
        System.out.print("\nEnter passenger name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter passenger ID number: ");
        String passengerIdNumber = scanner.nextLine();
        Passenger passenger = new Passenger(passengerName, passengerIdNumber);

        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        String schedule = selectSchedule(scanner);
        List<Seat> availableSeats = new TrainRoute.TrainRouteBuilder().setAvailableSeats(new ArrayList<>()).build().generateSeats(50);

        TrainRoute route = new TrainRoute.TrainRouteBuilder()
                .setSource(source)
                .setDestination(destination)
                .setSchedule(schedule)
                .setAvailableSeats(availableSeats)
                .build();

        // Display available seats
        System.out.println("Available seats:");
        for (Seat seat : availableSeats) {
            System.out.print(seat.getSeatNumber() + " ");
        }
        System.out.println();

        // Select seat
        System.out.print("Enter seat number to reserve: ");
        String selectedSeatNumber = scanner.nextLine();
        Seat selectedSeat = null;
        for (Seat seat : availableSeats) {
            if (seat.getSeatNumber().equals(selectedSeatNumber)) {
                selectedSeat = seat;
                break;
            }
        }

        // Book Ticket
        TicketBookingSystem bookingSystem = TicketBookingSystem.getInstance();
        TrainTicket ticket = bookingSystem.bookTicket(route, passenger, selectedSeat);

        // Display ticket details
        System.out.println("\nTicket booked successfully:");
        System.out.println("Route: " + ticket.getRoute());
        System.out.println("Date: " + ticket.getDate());
        System.out.println("Passenger: " + ticket.getPassenger().getName());
        System.out.println("Seat: " + ticket.getSeat().getSeatNumber());
    }

    private static String selectSchedule(Scanner scanner) {
        // Display schedule options
        System.out.println("Available schedules:");
        System.out.println("1. 08:00 AM");
        System.out.println("2. 12:00 PM");
        System.out.println("3. 04:00 PM");

        // Get user choice
        System.out.print("Enter schedule number: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Map choice to schedule
        switch (choice) {
            case 1:
                return "08:00 AM";
            case 2:
                return "12:00 PM";
            case 3:
                return "04:00 PM";
            default:
                System.out.println("Invalid choice. Defaulting to 08:00 AM.");
                return "08:00 AM";
        }
    }
}