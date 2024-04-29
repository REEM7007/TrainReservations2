package trainreservations;

public class Passenger {
    private String name;
    private String idNumber;

    public Passenger(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }
}