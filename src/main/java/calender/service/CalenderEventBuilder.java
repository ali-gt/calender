package calender.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import calender.beans.CalenderRequest;
import calender.beans.CalenderResponse;
import calender.database.EventsDatabase;
import calender.model.CalenderEvent;

@Service
public class CalenderEventBuilder {
	
	private static Map<String, CalenderEvent> events = EventsDatabase.getEvents();
	private String calenderUser = null;
	private CalenderEvent calenderEvent = null;
	
	
	public CalenderResponse buildEvent(CalenderRequest request) {
		calenderUser = request.getUser();
		calenderEvent = new CalenderEvent(request.getTitle(), request.getEventDate(), request.getLocation(), request.getAttendeeList(), request.getRemainder(), request.getRemainderFlag());
		events.put(calenderUser, calenderEvent);
		CalenderResponse response = new CalenderResponse();
		response.setStatus("200");
		response.setStatusMessage("Successfully added calender event");
		/*
		int duration = request.getDuration();
		String eventDate = request.getEventDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy hh:mm");
		LocalDate formattedEventDate = null;
		LocalDate scheduledEventDate = null;
		LocalDate now = LocalDate.now();
		if(eventDate != null && !eventDate.isEmpty()) {
			formattedEventDate = LocalDate.parse(eventDate, formatter);
			scheduledEventDate = formattedEventDate.plus(duration, ChronoUnit.MINUTES);
		}
		
		
		long alert = ChronoUnit.MINUTES.between(formattedEventDate, now);
		if(alert < 3) {
			System.out.println("EVENT IS HAPPENING NOW!");
		}*/
		return response;
	}
	
	public CalenderResponse retrieveEvents(CalenderRequest request) {
		CalenderResponse response = new CalenderResponse();
		String user = request.getUser();
		CalenderEvent event = events.get(user);	
		response.setStatus("200");
		response.setStatusMessage("The event '" + event.getTitle() + "' occurs " + event.getEventDate() + " at " + event.getLocation());
		return response;
	}
	
	public CalenderResponse removeEvent(CalenderRequest request) {
		CalenderResponse response = new CalenderResponse();
		String user = request.getUser();
		events.remove(user);
		response.setStatus("200");
		response.setStatusMessage("Successfully removed " + user);
		return response;
	}
}
