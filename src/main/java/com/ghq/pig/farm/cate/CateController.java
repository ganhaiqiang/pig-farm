package com.ghq.pig.farm.cate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CateController {

	@GetMapping("/cate")
	public String index() {
		return "cate/cate";
	}
}
