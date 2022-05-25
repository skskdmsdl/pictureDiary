package com.project.solr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String Main(HttpServletRequest request, HttpSession session) throws Exception {
		
		session = request.getSession();

		return "/main";
	}

}
