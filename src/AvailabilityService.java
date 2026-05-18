import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AvailabilityService {

    public AvailabilityService() {

    }

    public List<LocalDateTime> getAvailableTimes(Counselor c) {
        List<LocalDateTime> availableTimes = new ArrayList<>();
        Availability availability = c.getAvailability();
        if (availability == null)
            return availableTimes;

        TypicalAvailability typicalAvailability = availability.getTypicalAvailability();
        if (typicalAvailability == null)
            return availableTimes;

        Set<DayOfWeek> activeDays = typicalAvailability.getActiveDays();
        List<TimeRange> timeRanges = typicalAvailability.getTimeRanges();
        Set<DateRange> daysOff = availability.getDaysOff();
        List<Booking> bookedSlots = availability.getBookedDays();
        Set<TimeRange> unavailableTimeRanges = availability.getUnavailableTimeRanges();

        LocalDate today = LocalDate.now();
        for (int i = 0; i < 7; i++) { 
            LocalDate date = today.plusDays(i);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (!activeDays.contains(dayOfWeek))
                continue;

            boolean isOff = false;
            for (DateRange off : daysOff) {
                if (!date.isBefore(off.getStartDate()) && !date.isAfter(off.getEndDate())) {
                    isOff = true;
                    break;
                }
            }
            if (isOff)
                continue;

            for (TimeRange range : timeRanges) {
                LocalTime start = range.getStartTime();
                LocalTime end = range.getEndTime();
                LocalTime current = start;
                while (current.isBefore(end)) {
                    LocalDateTime slot = LocalDateTime.of(date, current);
                    boolean available = true;


                    for (TimeRange unavail : unavailableTimeRanges) {
                        if (!current.isBefore(unavail.getStartTime()) && !current.isAfter(unavail.getEndTime())) {
                            available = false;
                            break;
                        }
                    }

                    // check booked slots
                    if (available) {
                        for (Booking booking : bookedSlots) {
                            if (booking.getTime().equals(slot)) {
                                available = false;
                                break;
                            }
                        }
                    }

                    if (available) {
                        availableTimes.add(slot);
                    }

                    current = current.plusMinutes(30); // 30-minute slots
                }
            }
        }

        return availableTimes;
    }

}
