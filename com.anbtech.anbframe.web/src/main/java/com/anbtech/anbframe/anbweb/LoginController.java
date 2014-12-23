package com.anbtech.anbframe.anbweb;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anbtech.anbframe.security.CustomAuthenticationProvider;
import com.anbtech.anbframe.security.service.LoginService;



@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Locale locale, Model model){
		return "security/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/loginprocess", method=RequestMethod.POST)
	public ModelMap loginProcess(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		ModelMap map = new ModelMap();

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
			username, password);

		try {
			// 로그인
			Authentication auth = customAuthenticationProvider.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);

			map.put("success", true);
			//map.put("returnUrl", getReturnUrl(request, response));
		} catch (BadCredentialsException e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		}

		return map;
	}
	
	
}
