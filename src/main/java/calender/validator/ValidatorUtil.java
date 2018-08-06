package calender.validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ValidatorUtil {
	
	/*
	 * Utility that validates the event date format.
	 */
	public static void validateDate(String eventDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime formattedEventDate = null;
		LocalDateTime now = LocalDateTime.now();
		if(eventDate != null && !eventDate.isEmpty()) {
			formattedEventDate = LocalDateTime.parse(eventDate, formatter);
		}
		//long alert = ChronoUnit.MINUTES.between(formattedEventDate, now);
	}
}
