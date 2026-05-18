import java.time.LocalTime;

public class TimeRange {
    private LocalTime start;
    private LocalTime end;

    public TimeRange(LocalTime start, LocalTime end){
        this.start = start;
        this.end = end;
    }

    public LocalTime getStartTime(){
        return start;
    }

    public LocalTime getEndTime(){
        return end;
    }
    @Override
    public String toString(){
        return("From " + start + " to " + end);
    }
}

