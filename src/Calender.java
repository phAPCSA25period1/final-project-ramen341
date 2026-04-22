import java.util.ArrayList;

public class Calender {
    private ArrayList<Event> events;

    public Calender() {
        events = new ArrayList<>();
    }

    public boolean addEvent(Event event) {
        // Check for conflicts: same student or same date/time
        for (Event e : events) {
            if (event.getStudentName().equals(e.getStudentName())) {
                return false; // Student already has an appointment
            }
            if (event.getDate().equals(e.getDate()) && event.getTime().equals(e.getTime())) {
                return false; // Time slot already taken
            }
        }
        events.add(event);
        return true;
    }

    public boolean removeEvent(Event event) {
        return events.remove(event);
    }

    public ArrayList<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public ArrayList<Event> getEventsByDate(String date) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }

    public Event findEvent(String studentName, String date, String time) {
        for (Event event : events) {
            if (event.getStudentName().equals(studentName)
                    && event.getDate().equals(date)
                    && event.getTime().equals(time)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Calender{" +
                "events=" + events +
                '}';
    }
}
