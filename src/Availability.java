import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Availability {
    private TypicalAvailability typicalAvailibility;
    private Set<DateRange> daysOff;
    private Set<TimeRange> unavailableTimeRanges;
    private List<Booking> bookedSlots;

    public Availability(TypicalAvailability typicalDays, Set<DateRange> daysOff, List<Booking> bookedSlots,
            Set<TimeRange> unavailableTimeRanges) {
        this.typicalAvailibility = typicalDays;
        this.daysOff = new HashSet<>(daysOff);
        this.bookedSlots = bookedSlots;
        this.unavailableTimeRanges = unavailableTimeRanges;
    }

    public TypicalAvailability getTypicalAvailability() {
        return typicalAvailibility;
    }

    public Set<DateRange> getDaysOff() {
        return daysOff;
    }

    public boolean addDayOff(DateRange requestedDay) {
        return daysOff.add(requestedDay);
    }

    public boolean removeDayOff(DateRange requestedDay) {
        return daysOff.remove(requestedDay);
    }

    public List<Booking> getBookedDays() {
        return bookedSlots;
    }

    public boolean addBookedDay(Booking booking) {
        return bookedSlots.add(booking);
    }

    public boolean removeBookedDay(Booking booking) {
        return bookedSlots.remove(booking);
    }

    public Set<TimeRange> getUnavailableTimeRanges() {
        return unavailableTimeRanges;
    }

}
