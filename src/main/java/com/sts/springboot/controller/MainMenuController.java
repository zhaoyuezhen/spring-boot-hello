package com.sts.springboot.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.springboot.service.AuthUserService;
@Controller
public class MainMenuController {
	@Autowired
    AuthUserService authUserService;
	
	@RequestMapping("/main_menu")
	public String mainMenu(HttpServletRequest request ,Principal principal) {
		String loginId = principal.getName();
		String authorityKind = authUserService.getAllAuthority(loginId);
    	request.getSession().setAttribute("authorityKind", authorityKind);
    	return "redirect:/index";
	}
}	
