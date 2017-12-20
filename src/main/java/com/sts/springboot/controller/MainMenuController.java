package com.sts.springboot.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sts.springboot.service.AuthUserService;
@Controller
@EnableWebSecurity
@EnableAutoConfiguration
public class MainMenuController {
	@Autowired
    AuthUserService authUserService;
	
	@RequestMapping("/main_menu")
	public String mainMenu(HttpServletRequest request, Principal principal, ModelAndView model) throws Exception  {
	//public String mainMenu(HttpServletRequest request ,Principal principal) {
		String loginId = principal.getName();
		String authorityKind = authUserService.getAuthorityByLoginId(loginId);
    	//request.getSession().setAttribute("authorityKind", authorityKind);
    	
    	request.getSession().setAttribute("authorityKindMap", authorityKind);
    	
    	return "main_menu";
	}
}	
