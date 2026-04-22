public class Event {
    private String studentName;
    private String counselorName;
    private String date;
    private String time;
    private String purpose;
    private boolean confirmed;

    public Event(String studentName, String counselorName, String date, String time, String purpose) {
        this.studentName = studentName;
        this.counselorName = counselorName;
        this.date = date;
        this.time = time;
        this.purpose = purpose;
        this.confirmed = false;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCounselorName() {
        return counselorName;
    }

    public void setCounselorName(String counselorName) {
        this.counselorName = counselorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Event{" +
                "studentName='" + studentName + '\'' +
                ", counselorName='" + counselorName + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", purpose='" + purpose + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }
}
