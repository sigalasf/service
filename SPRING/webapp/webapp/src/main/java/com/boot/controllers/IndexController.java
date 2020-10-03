package com.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.configuration.ConfigProperties;

@Controller
public class IndexController {
	
	@Autowired
	private ConfigProperties configProperties;
	
	@RequestMapping("/")
	String index(Model model) {
		model.addAttribute("config", configProperties);
		return "index";
	}
}
