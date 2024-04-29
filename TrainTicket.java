package trainreservations;

public class TrainTicket {
    private String route;
    private String date;
    private Passenger passenger;
    private Seat seat;

    public TrainTicket(String route, String date, Passenger passenger, Seat seat) {
        this.route = route;
        this.date = date;
        this.passenger = passenger;
        this.seat = seat;
    }

    public String getRoute() {
        return route;
    }

    public String getDate() {
        return date;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Seat getSeat() {
        return seat;
    }
}