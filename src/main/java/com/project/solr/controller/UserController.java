package com.project.solr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.solr.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(@RequestParam Map<String, String> map) throws Exception {
		System.out.println(map.get("id")); //Object여서 형 변환
        System.out.println(map.get("email"));
        
        String id = map.get("id");
        String email = map.get("email");
        
        // 소셜
        if(userService.login(id, email)) {
        	return "login";
        }
        
        return "join";
        
        
	}
	
	@RequestMapping("/join.do")
	public String Join() throws Exception {
		return "user/join";
	}

}