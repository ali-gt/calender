package calender.model;

import java.time.LocalDate;
import java.util.List;

public class CalenderEvent {
	
	private String title;
	private String eventDate;
	private String location;
	private List<String> attendeeList;
	private String remainder;
	private boolean remainderFlag;
	
	public CalenderEvent() {
		
	}
	
	public CalenderEvent(String title, String eventDate, String location, List<String> attendeeList, String remainder, boolean remainderFlag) {
		this.title = title;
		this.eventDate = eventDate;
		this.location = location;
		this.attendeeList = attendeeList;
		this.remainder = remainder;
		this.remainderFlag = remainderFlag;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<String> getAttendeeList() {
		return attendeeList;
	}
	
	public void setAttendeeList(List<String> attendeeList) {
		this.attendeeList = attendeeList;
	}
	
	public String getRemainder() {
		return remainder;
	}
	
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}
	
	public boolean getRemainderFlag() {
		return remainderFlag;
	}
	
	public void setRemainderFlag(boolean remainderFlag) {
		this.remainderFlag = remainderFlag;
	}
}
