package trainreservations;

import java.util.Date;

//This class follows the Singleton Design Pattern
public class TicketBookingSystem {
 private static TicketBookingSystem instance;

 // Private constructor to prevent instantiation from outside
 private TicketBookingSystem() {
 }

 public static TicketBookingSystem getInstance() {
     if (instance == null) {
         instance = new TicketBookingSystem();
     }
     return instance;
 }

 // Assume booking logic here
 // Get current date
 // Reserve the seat
 public TrainTicket bookTicket(TrainRoute route, Passenger passenger, Seat seat) {
     String ticketRoute = route.getSource() + " to " + route.getDestination();
     String currentDate = new Date().toString();
     route.getAvailableSeats().remove(seat);
     return new TrainTicket(ticketRoute, currentDate, passenger, seat);
 }
}