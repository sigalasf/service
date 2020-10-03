package com.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.configuration.ConfigProperties;

@Controller
public class LoginController {

	
	@Autowired
	ConfigProperties configProperties;
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("config", configProperties);
		return "login";
	}
}