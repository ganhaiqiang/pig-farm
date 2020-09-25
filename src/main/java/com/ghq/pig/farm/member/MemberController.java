package com.ghq.pig.farm.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/member-add")
	public String memberAdd() {
		return "member/member-add";
	}

	@GetMapping("/member-del")
	public String memberDel() {
		return "member/member-del";
	}

	@GetMapping("/member-edit")
	public String memberEdit() {
		return "member/member-edit";
	}

	@GetMapping("/member-list")
	public String memberList() {
		return "member/member-list";
	}

	@GetMapping("/member-list1")
	public String memberList1() {
		return "member/member-list1";
	}

	@GetMapping("/member-password")
	public String memberPassword() {
		return "member/member-password";
	}
}
