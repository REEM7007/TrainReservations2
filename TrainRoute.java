package trainreservations;

import java.util.ArrayList;
import java.util.List;

// This class follows the Builder Design Pattern
public class TrainRoute {
    private String source;
    private String destination;
    private String schedule;
    private List<Seat> availableSeats;

    private TrainRoute(TrainRouteBuilder builder) {
        this.source = builder.source;
        this.destination = builder.destination;
        this.schedule = builder.schedule;
        this.availableSeats = builder.availableSeats;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public static class TrainRouteBuilder {
        private String source;
        private String destination;
        private String schedule;
        private List<Seat> availableSeats;

        public TrainRouteBuilder setSource(String source) {
            this.source = source;
            return this;
        }

        public TrainRouteBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public TrainRouteBuilder setSchedule(String schedule) {
            this.schedule = schedule;
            return this;
        }

        public TrainRouteBuilder setAvailableSeats(List<Seat> availableSeats) {
            this.availableSeats = availableSeats;
            return this;
        }

        public TrainRoute build() {
            return new TrainRoute(this);
        }
    }

    public List<Seat> generateSeats(int numberOfSeats) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(String.valueOf(i)));
        }
        return seats;
    }
}