package task;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
	
	public static LocalDate dateToLocalDate(Date date) {
		Instant instant = date.toInstant();
		return instant.atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalTime dateToLocalTime(Date date) {
		Instant instant = date.toInstant();
		return instant.atZone(ZoneId.systemDefault()).toLocalTime();
	}
	
	public static LocalDateTime dateToLocalDateTime(Date date) {
		Instant instant = date.toInstant();
		return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}
