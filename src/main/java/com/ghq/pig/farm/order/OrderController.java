package com.ghq.pig.farm.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

	@GetMapping("/order-add")
	public String orderAdd() {
		return "order/order-add";
	}

	@GetMapping("/order-list")
	public String orderList() {
		return "order/order-list";
	}

	@GetMapping("/order-list1")
	public String orderList1() {
		return "order/order-list1";
	}
}
