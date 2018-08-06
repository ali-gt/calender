package calender.database;

import java.util.HashMap;
import java.util.Map;

import calender.model.Calender;
import calender.model.CalenderEvent;

public class EventsDatabase {
	
	private static Map<String, CalenderEvent> events = new HashMap<>();
	
	public static Map<String, CalenderEvent> getEvents() {
		return events;
	}
	
}
