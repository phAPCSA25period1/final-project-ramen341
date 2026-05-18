import java.time.LocalDateTime;

public class Booking {
    private int studentId;
    private String counselerName;
    private LocalDateTime time;

    public Booking(int studentId, String counselerName, LocalDateTime time) {
        this.studentId = studentId;
        this.counselerName = counselerName;
        this.time = time;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCounselerName() {
        return counselerName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String toString() {
        return "Student " + studentId + " booked on " + time + " with " + counselerName;
    }

}
