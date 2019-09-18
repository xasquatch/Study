package com.playbigfoot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home() {

		log.debug("hidddddd");
		log.info("hisdfasdfasdfasd");
		return "home";
	}

}