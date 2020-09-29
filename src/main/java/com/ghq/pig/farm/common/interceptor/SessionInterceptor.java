package com.ghq.pig.farm.common.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ghq.pig.farm.common.Constant;

public class SessionInterceptor implements HandlerInterceptor {
	private static List<String> ignoreList = Arrays.asList("/login", "/logout");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		if (ignoreList.contains(requestUri)) {
			return true;
		}
		Object object = request.getSession().getAttribute(Constant.USER_SESSION_NAME);
		if (null == object) {
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}
}
