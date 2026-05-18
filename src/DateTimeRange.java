import java.time.LocalDateTime;

public class DateTimeRange {
    private LocalDateTime start;
    private LocalDateTime end;

    public DateTimeRange(LocalDateTime start, LocalDateTime end){
        this.start = start;
        this.end = end;

    }

    public LocalDateTime getStart(){
        return start;
    }


    public LocalDateTime getEnd(){
        return end;
    }



}
