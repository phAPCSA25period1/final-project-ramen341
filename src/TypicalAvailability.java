import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public class TypicalAvailability {
    private Set<DayOfWeek> activeDays;
    private List<TimeRange> availableTimeRanges;

    public TypicalAvailability(List<TimeRange> availableTimeRanges, Set<DayOfWeek> activeDays) {
        this.activeDays = activeDays;
        this.availableTimeRanges = availableTimeRanges;
    }

    public Set<DayOfWeek> getActiveDays() {
        return activeDays;
    }

    public List<TimeRange> getTimeRanges() {
        return availableTimeRanges;
    }

    public String toString() {
        return ("The typical days are: " + activeDays + "\n" +
                "The typical time ranges are " + availableTimeRanges);
    }

}
