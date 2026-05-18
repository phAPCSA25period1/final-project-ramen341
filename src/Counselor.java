public class Counselor {
    private String name;
    private Availability availability;

    public Counselor(String name, Availability availability) {
        this.name = name;
        this.availability = availability;

    }

    public Availability getAvailability() {
        return availability;
    }

    public String getName() {
        return name;
    }
}
