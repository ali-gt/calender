package calender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import calender.beans.CalenderRequest;
import calender.beans.CalenderResponse;
import calender.service.CalenderEventBuilder;

@RestController
public class CalenderController {
	
	@Autowired
	private CalenderEventBuilder builder;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CalenderResponse createCalenderEvent(@RequestBody CalenderRequest request) {
		return builder.buildEvent(request);
	}
	
	@RequestMapping(value = "/retrieve", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CalenderResponse retrieveCalenderEvents(@RequestBody CalenderRequest request) {
		return builder.retrieveEvents(request);
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CalenderResponse removeCalenderEvents(@RequestBody CalenderRequest request) {
		return builder.removeEvent(request);
	}
}
