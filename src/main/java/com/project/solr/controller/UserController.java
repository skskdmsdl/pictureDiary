package com.project.solr.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void Login(@RequestParam Map<String, String> map) throws Exception {
		System.out.println(map.get("id")); //Object여서 형 변환
        System.out.println(map.get("email"));
        
        String id = map.get("id");
        String email = map.get("email");
        
        
        
        
        
	}
	
	@RequestMapping("/join.do")
	public String Join() throws Exception {
		return "user/join";
	}

}