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
	
	/*
	 * Builds the the event from the request and stores it into a Map.
	 */
	public CalenderResponse buildEvent(CalenderRequest request) {
		calenderUser = request.getUser();
		calenderEvent = new CalenderEvent(request.getTitle(), request.getEventDate(), request.getLocation(), request.getAttendeeList(), request.getRemainder(), request.getRemainderFlag());
		events.put(calenderUser, calenderEvent);
		CalenderResponse response = new CalenderResponse();
		response.setStatus("200");
		response.setStatusMessage("Successfully added calender event");
		return response;
	}
	
	/*
	 * Retrieves the the event from the request user.	
	 */
	public CalenderResponse retrieveEvents(CalenderRequest request) {
		CalenderResponse response = new CalenderResponse();
		String user = request.getUser();
		CalenderEvent event = events.get(user);
		if(event != null) {
			response.setStatus("200");
			response.setStatusMessage("The event '" + event.getTitle() + "' occurs " + event.getEventDate() + " at " + event.getLocation());
			return response;
		}
		response.setStatus("100");
		response.setStatusMessage("No data found for the user " + user);
		return response;
	}
	
	/*
	 * Removes the event User from the Map.
	 */
	public CalenderResponse removeEvent(CalenderRequest request) {
		CalenderResponse response = new CalenderResponse();
		String user = request.getUser();
		events.remove(user);
		response.setStatus("200");
		response.setStatusMessage("Successfully removed " + user);
		return response;
	}
	
	/*
	 * Updates event user.	
	 */
	public CalenderResponse updateEvent(CalenderRequest request) {
		CalenderResponse response = new CalenderResponse();
		String user = request.getUser();
		CalenderEvent event = events.get(user);
		if(event != null) {
			event.setAttendeeList(request.getAttendeeList());
			event.setEventDate(request.getEventDate());
			event.setLocation(request.getLocation());
			event.setRemainder(request.getRemainder());
			event.setRemainderFlag(request.getRemainderFlag());
			event.setTitle(request.getTitle());
			response.setStatus("200");
			response.setStatusMessage("The event has been updated for the user " + user);
			return response;
		}
		response.setStatus("100");
		response.setStatusMessage("No data found for the user " + user);
		return response;
	}
}
