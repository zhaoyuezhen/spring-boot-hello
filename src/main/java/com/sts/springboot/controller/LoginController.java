package com.sts.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sts.springboot.dto.UserDto;

@Controller
public class LoginController {
	
	//初期化
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("userDto",userDto);
		return "login";
	}
	
	//登录
	@RequestMapping(value = "/login",params="action=login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userPsw") String userPsw,Model model,RedirectAttributes redirectAttributes ) {
		UserDto userDto = new UserDto();
		if(userName.equals(userPsw)) {
			redirectAttributes.addFlashAttribute("userName",userName); 
			return "redirect:index";
		} else {
			model.addAttribute("loginError",true);
			model.addAttribute("userDto",userDto);
			return "login";
		}
	}
	@RequestMapping("/index")
	public String welcomeIndex(@ModelAttribute("userName") String userName,Model model) {
		model.addAttribute("userName",userName);
		return "index";
	}

}
