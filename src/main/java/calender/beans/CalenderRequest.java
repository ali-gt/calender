package calender.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalenderRequest {
	
	private String user;
	private String name;
	private String title;
	private String eventDate;
	private int duration;
	private String location;
	private List<String> attendeeList;
	private String remainder;
	private boolean remainderFlag;
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@JsonProperty("User")
	public String getUser() {
		return user;
	}
	
	@JsonProperty("User")
	public void setUser(String user) {
		this.user = user;
	}
	
	@JsonProperty("Name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}
	
	@JsonProperty("Title")
	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonProperty("EventDate")
	public String getEventDate() {
		return eventDate;
	}
	
	@JsonProperty("EventDate")
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	@JsonProperty("Location")
	public String getLocation() {
		return location;
	}
	
	@JsonProperty("Location")
	public void setLocation(String location) {
		this.location = location;
	}
	
	@JsonProperty("AttendeeList")
	public List<String> getAttendeeList() {
		return attendeeList;
	}
	
	@JsonProperty("AttendeeList")
	public void setAttendeeList(List<String> attendeeList) {
		this.attendeeList = attendeeList;
	}
	
	@JsonProperty("Remainder")
	public String getRemainder() {
		return remainder;
	}
	
	@JsonProperty("Remainder")
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}
	
	@JsonProperty("RemainderFlag")
	public boolean getRemainderFlag() {
		return remainderFlag;
	}
	
	@JsonProperty("RemainderFlag")
	public void setRemainderFlag(boolean remainderFlag) {
		this.remainderFlag = remainderFlag;
	}

}
