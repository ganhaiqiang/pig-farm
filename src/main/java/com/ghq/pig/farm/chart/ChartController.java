package com.ghq.pig.farm.chart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {

	@GetMapping("/echarts1")
	public String echarts1() {
		return "chart/echarts1";
	}

	@GetMapping("/echarts2")
	public String echarts2() {
		return "chart/echarts2";
	}

	@GetMapping("/echarts3")
	public String echarts3() {
		return "chart/echarts3";
	}

	@GetMapping("/echarts4")
	public String echarts4() {
		return "chart/echarts4";
	}

	@GetMapping("/echarts5")
	public String echarts5() {
		return "chart/echarts5";
	}

	@GetMapping("/echarts6")
	public String echarts6() {
		return "chart/echarts6";
	}

	@GetMapping("/echarts7")
	public String echarts7() {
		return "chart/echarts7";
	}

	@GetMapping("/echarts8")
	public String echarts8() {
		return "chart/echarts8";
	}
}
