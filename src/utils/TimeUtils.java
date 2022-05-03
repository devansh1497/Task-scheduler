package utils;

import enums.Duration;

import java.time.LocalDateTime;

public class TimeUtils {

    public static LocalDateTime addTime(Duration duration, int amount, LocalDateTime time) {
        if(duration == Duration.HOURS) {
            return time.plusHours(amount);
        }
        else if(duration == Duration.MONTHS) {
            return time.plusMonths(amount);
        }
        else if(duration == Duration.WEEKS) {
            return time.plusDays(7L * amount);
        }
        else if(duration == Duration.DAYS) {
            return time.plusDays(amount);
        }
        else if(duration == Duration.YEAR) {
            return time.plusYears(amount);
        }
        else if(duration == Duration.SECONDS) {
            return time.plusSeconds(amount);
        }
        return null;
    }
}
