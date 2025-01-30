package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    private LocalDateTime DateTimeCurrent;

    public DateTime() {
        this.DateTimeCurrent = LocalDateTime.now();
    }

    public String now() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return DateTimeCurrent.format(formatter);
    }
}