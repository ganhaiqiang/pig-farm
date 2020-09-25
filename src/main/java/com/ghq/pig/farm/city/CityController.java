package com.ghq.pig.farm.city;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

	@GetMapping("/city")
	public String index() {
		return "city/city";
	}
}
