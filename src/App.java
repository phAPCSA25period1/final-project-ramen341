import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calender calender = new Calender();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Appointment Menu ===");
            System.out.println("1. Book an appointment");
            System.out.println("2. View all appointments");
            System.out.println("3. View appointments by date");
            System.out.println("4. Cancel an appointment");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    bookAppointment(scanner, calender);
                    break;
                case 2:
                    viewAllAppointments(calender);
                    break;
                case 3:
                    viewByDate(scanner, calender);
                    break;
                case 4:
                    cancelAppointment(scanner, calender);
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static void bookAppointment(Scanner scanner, Calender calender) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter counselor name: ");
        String counselorName = scanner.nextLine();

        System.out.print("Enter date (e.g., 04/22/2026): ");
        String date = scanner.nextLine();

        System.out.print("Enter time (e.g., 10:00 AM): ");
        String time = scanner.nextLine();

        System.out.print("Enter purpose: ");
        String purpose = scanner.nextLine();

        Event event = new Event(studentName, counselorName, date, time, purpose);

        if (calender.addEvent(event)) {
            System.out.println("Appointment booked successfully!");
        } else {
            System.out.println("Failed to book appointment. Check for conflicts.");
        }
    }

    private static void viewAllAppointments(Calender calender) {
        ArrayList<Event> events = calender.getAllEvents();

        if (events.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("\n=== All Appointments ===");
            for (Event e : events) {
                System.out.println(e);
            }
        }
    }

    private static void viewByDate(Scanner scanner, Calender calender) {
        System.out.print("Enter date to view: ");
        String date = scanner.nextLine();

        ArrayList<Event> events = calender.getEventsByDate(date);

        if (events.isEmpty()) {
            System.out.println("No appointments on that date.");
        } else {
            System.out.println("\n=== Appointments on " + date + " ===");
            for (Event e : events) {
                System.out.println(e);
            }
        }
    }

    private static void cancelAppointment(Scanner scanner, Calender calender) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter date: ");
        String date = scanner.nextLine();

        System.out.print("Enter time: ");
        String time = scanner.nextLine();

        Event event = calender.findEvent(studentName, date, time);

        if (event != null) {
            calender.removeEvent(event);
            System.out.println("Appointment cancelled.");
        } else {
            System.out.println("Appointment not found.");
        }
    }
}
