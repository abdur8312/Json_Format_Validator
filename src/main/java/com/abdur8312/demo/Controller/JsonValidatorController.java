package com.abdur8312.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.abdur8312.demo.Validator.ValidationResponse;
import com.abdur8312.demo.Validator.Validator;

@RestController
public class JsonValidatorController {

	@PostMapping(value = "/validate", consumes = "text/plain", produces = "application/json")
	public ValidationResponse process(@RequestBody String payload) {
		
		ValidationResponse vr = new ValidationResponse();
		boolean retValue = false;
		retValue = Validator.isValid(payload);
		if(retValue) {
			vr.setMessage("Valid JSON");
		}
		else {
			vr.setMessage("Invalid JSON");
		}
		System.out.println("Value : " + payload);
		System.out.println("\nJSON value : " + vr.getMessage() + "\n");
		return vr;
		
	}
}
