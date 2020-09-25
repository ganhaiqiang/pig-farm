package com.ghq.pig.farm.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("admin-add")
	public String adminAdd() {
		return "admin/admin-add";
	}

	@GetMapping("admin-cate")
	public String adminCate() {
		return "admin/admin-cate";
	}

	@GetMapping("admin-edit")
	public String adminEdit() {
		return "admin/admin-edit";
	}

	@GetMapping("admin-list")
	public String adminList() {
		return "admin/admin-list";
	}

	@GetMapping("admin-role")
	public String adminRole() {
		return "admin/admin-role";
	}

	@GetMapping("admin-rule")
	public String adminRule() {
		return "admin/admin-rule";
	}

	@GetMapping("role-add")
	public String roleAdd() {
		return "admin/role-add";
	}
}
