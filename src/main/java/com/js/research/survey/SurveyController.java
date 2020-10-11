package com.js.research.survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {
	
	@GetMapping("/")
	public String experiment() {
		return "experiment";
	}

}
