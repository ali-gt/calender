package calender.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import calender.beans.CalenderRequest;

@Component
public class CalenderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CalenderRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CalenderRequest request = (CalenderRequest) target;
		String eventDate = request.getEventDate();
		try {
			ValidatorUtil.validateDate(eventDate);
		} catch (Exception e) {
			errors.reject("ERROR BAD REQUEST");
			e.printStackTrace();
		}		
	}	
}
