package calender.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import calender.beans.CalenderRequest;
import calender.beans.CalenderResponse;
import calender.service.CalenderEventBuilder;
import calender.validator.CalenderValidator;

@RestController
public class CalenderController {
	
	@Autowired
	private CalenderEventBuilder builder;
	
	@Autowired
	private CalenderValidator validator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CalenderResponse createCalenderEvent(@RequestBody @Valid CalenderRequest request, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			CalenderResponse response = new CalenderResponse();
			response.setStatus("300");
			response.setStatusMessage("ERROR: Your event date must be of the format yyyy-MM-dd HH:mm, military time e.g. 2018-08-06 11:06");
			return response;
		}
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
