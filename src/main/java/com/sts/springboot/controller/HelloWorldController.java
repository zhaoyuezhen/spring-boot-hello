package com.sts.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sts.springboot.dto.UserDto;

@Controller
public class HelloWorldController {
	UserDto userDto = new UserDto();
	/*
	 * @RequestMapping("/helloWorld") public String hello(){ return "hello world"; }
	 */

	@RequestMapping("/")
	// @ResponseBody /*如果使用左记注解 是直接 返回值的内容输出的页面上*/
	public String welcome(Model model) {
		model.addAttribute("userDto",userDto);
		return "login";
	}
	

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String loginTest(@RequestParam String inputStr, HttpServletRequest request) {
		System.out.println(inputStr);
		System.out.println(request.getParameter("inputInt"));
		return "index";
	}

}
