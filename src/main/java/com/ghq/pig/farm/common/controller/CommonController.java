package com.ghq.pig.farm.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ghq.pig.farm.disease.entity.DiseaseNews;
import com.ghq.pig.farm.disease.service.IDiseaseNewsService;

@Controller
public class CommonController {

	@Autowired
	private IDiseaseNewsService diseaseNewsService;

	@GetMapping(value = { "/", "/index" })
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/welcome1")
	public String welcome1() {
		return "welcome1";
	}

	@GetMapping("/test")
	public ModelAndView test() {
		DiseaseNews diseaseNews = diseaseNewsService.getById(10001);
		return new ModelAndView("test").addObject("diseaseNews", diseaseNews);
	}
}
