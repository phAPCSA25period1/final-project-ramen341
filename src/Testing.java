import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TimeRange morning = new TimeRange(LocalTime.of(9, 0), LocalTime.of(12, 0));
        List<TimeRange> timeRanges = List.of(morning);

        Set<DayOfWeek> activeDays = Set.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY);

        TypicalAvailability typicalAvail = new TypicalAvailability(timeRanges, activeDays);

        Set<DateRange> daysOff = Set.of();
        List<Booking> bookedSlots = new ArrayList<>();
        Set<TimeRange> unavailableTimes = Set.of();
        Availability availability = new Availability(typicalAvail, daysOff, bookedSlots, unavailableTimes);


        Counselor counselor = new Counselor("Dr. Smith", availability);

        AvailabilityService service = new AvailabilityService();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Counseling Appointment System ===");
            System.out.println("1. View Available Times");
            System.out.println("2. Book an Appointment");
            System.out.println("3. View Booked Appointments");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAvailableTimes(service, counselor);
                    break;
                case 2:
                    bookAppointment(scanner, service, counselor);
                    break;
                case 3:
                    viewBookedAppointments(counselor);
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static void viewAvailableTimes(AvailabilityService service, Counselor counselor) {
        List<java.time.LocalDateTime> availableTimes = service.getAvailableTimes(counselor);
        if (availableTimes.isEmpty()) {
            System.out.println("No available times.");
        } else {
            System.out.println("\nAvailable Times:");
            for (int i = 0; i < availableTimes.size(); i++) {
                System.out.println((i + 1) + ". " + availableTimes.get(i));
            }
        }
    }

    private static void bookAppointment(Scanner scanner, AvailabilityService service, Counselor counselor) {
        List<java.time.LocalDateTime> availableTimes = service.getAvailableTimes(counselor);
        if (availableTimes.isEmpty()) {
            System.out.println("No available times to book.");
            return;
        }

        System.out.println("\nAvailable Times:");
        for (int i = 0; i < availableTimes.size(); i++) {
            System.out.println((i + 1) + ". " + availableTimes.get(i));
        }

        System.out.print("Enter the number of the time slot to book: ");
        int slotNumber = scanner.nextInt();
        scanner.nextLine();

        if (slotNumber < 1 || slotNumber > availableTimes.size()) {
            System.out.println("Invalid slot number.");
            return;
        }

        java.time.LocalDateTime selectedTime = availableTimes.get(slotNumber - 1);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        // Create booking
        Booking booking = new Booking(studentId, counselor.getName(), selectedTime);

        // Add to booked slots
        counselor.getAvailability().addBookedDay(booking);

        System.out.println("Appointment booked successfully!");
        System.out.println(booking);
    }

    private static void viewBookedAppointments(Counselor counselor) {
        List<Booking> booked = counselor.getAvailability().getBookedDays();
        if (booked.isEmpty()) {
            System.out.println("No booked appointments.");
        } else {
            System.out.println("\nBooked Appointments:");
            for (Booking b : booked) {
                System.out.println(b);
            }
        }
    }
}
