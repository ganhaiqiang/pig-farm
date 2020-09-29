package com.ghq.pig.farm.common.controller;

import java.util.Base64;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ghq.pig.farm.common.Constant;
import com.ghq.pig.farm.disease.entity.DiseaseNews;
import com.ghq.pig.farm.disease.service.IDiseaseNewsService;
import com.ghq.pig.farm.login.entity.UserLogin;
import com.ghq.pig.farm.login.service.IUserLoginService;

@Controller
@SessionAttributes(Constant.USER_SESSION_NAME)
public class CommonController {

	@Autowired
	private IDiseaseNewsService diseaseNewsService;

	@Autowired
	private IUserLoginService userLoginService;

	@GetMapping(value = { "", "index" })
	public String index() {
		return "index";
	}

	@GetMapping("logout")
	public String loginout(HttpSession session, SessionStatus sessionStatus) {
		session.removeAttribute(Constant.USER_SESSION_NAME);
		session.invalidate();
		sessionStatus.setComplete();
		return "redirect:login";
	}

	@GetMapping("login")
	public ModelAndView login(HttpSession session) {
		String token = UUID.randomUUID().toString();
		session.setAttribute(Constant.LOGIN_TOKEN, token);
		return new ModelAndView("login").addObject("token", token);
	}

	@PostMapping("login")
	public String login(@RequestParam("token") String tokenMd5,
			@RequestParam("username") String usernameBase64,
			@RequestParam("password") String passwordBase64,
			HttpSession session,
			Model model,
			RedirectAttributes redirectAttributes) throws Exception {
		String loginToken = (String) session.getAttribute(Constant.LOGIN_TOKEN);
		session.removeAttribute(Constant.LOGIN_TOKEN);
		String password = new String(Base64.getDecoder().decode(passwordBase64), "UTF-8");
		String md5 = DigestUtils.md5Hex(loginToken + password);
		if (!md5.equals(tokenMd5)) {
			redirectAttributes.addFlashAttribute("msg", "非法参数");
			return "redirect:login";
		}
		String usernameDecode = new String(Base64.getDecoder().decode(usernameBase64), "UTF-8");
		UserLogin userLogin = userLoginService.getOne(Wrappers.lambdaQuery(UserLogin.class).eq(UserLogin::getName, usernameDecode));
		if (userLogin == null) {
			redirectAttributes.addFlashAttribute("msg", "用户不存在");
			return "redirect:login";
		}
		if (!DigestUtils.sha256Hex(password).equals(userLogin.getPwd())) {
			redirectAttributes.addFlashAttribute("msg", "用户名或密码错误");
			return "redirect:login";
		}
		if (!userLogin.getEnable()) {
			redirectAttributes.addFlashAttribute("msg", "用户被禁止登录");
			return "redirect:login";
		}
		userLogin.setPwd(null);
		model.addAttribute(Constant.USER_SESSION_NAME, userLogin);
		return "redirect:";
	}

	@GetMapping("welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("welcome1")
	public String welcome1() {
		return "welcome1";
	}

	@GetMapping("test")
	public ModelAndView test() {
		DiseaseNews diseaseNews = diseaseNewsService.getById(10001);
		return new ModelAndView("test").addObject("diseaseNews", diseaseNews);
	}
}
