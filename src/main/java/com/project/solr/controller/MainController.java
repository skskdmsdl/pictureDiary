package com.project.solr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	/*
	 * @Autowired private GoogleConnectionFactory googleConnectionFactory;
	 * 
	 * @Autowired private OAuth2Parameters googleOAuth2Parameters;
	 */

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
