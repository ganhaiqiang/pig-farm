package com.ghq.pig.farm.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other")
public class OtherController {

	@GetMapping("/demo")
	public String demo() {
		return "other/demo";
	}

	@GetMapping("/error")
	public String error() {
		return "other/error";
	}

	@GetMapping("/log")
	public String log() {
		return "other/log";
	}

	@GetMapping("/unicode")
	public String unicode() {
		return "other/unicode";
	}
}
