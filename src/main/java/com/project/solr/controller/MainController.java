package com.project.solr.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String Main(Model model, HttpSession session) throws Exception {

		/* 구글code 발행 */
		/*
		 * OAuth2Operations oauthOperations =
		 * googleConnectionFactory.getOAuthOperations();
		 * 
		 * 로그인페이지 이동 url생성 String url =
		 * oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE,
		 * googleOAuth2Parameters);
		 * 
		 * model.addAttribute("google_url", url);
		 */
		return "main";
	}

}
