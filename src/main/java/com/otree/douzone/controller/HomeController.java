package com.otree.douzone.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "login";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homego(Locale locale, Model model) {		
		return "login";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "register";
	}
	
	@RequestMapping(value = "/sendemail", method = RequestMethod.GET)
	public String sendemail(Locale locale, Model model) {
		return "sendemail";
	}
	
	@RequestMapping(value = "/workspace", method = RequestMethod.GET)
	public String workspace(Locale locale, Model model) {
		return "workspace";
	}
	
	@RequestMapping(value = "/kanbanboardgo", method = RequestMethod.GET)
	public String kanbanboard(Locale locale, Model model) {
		return "kanban";
	}
	
	@RequestMapping(value = "boardgo", method = RequestMethod.GET)
	public String boardgo(Locale locale, Model model) {
		return "board";
	}
	
}