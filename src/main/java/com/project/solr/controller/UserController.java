package com.project.solr.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.solr.dto.LoginDto;
import com.project.solr.entity.UserEntity;
import com.project.solr.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;

	@PostMapping(value = "/login.do")
	public String Login(LoginDto loginDto, RedirectAttributes redirectAttr, HttpSession session ) throws Exception {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        
        // 계정 확인
        UserEntity user = userService.login(email, password);
        
        // 소셜 로그인 성공
        if(user != null){
        	session.setAttribute("nickname", user.getNickname());
        	session.setAttribute("userId", user.getUserId());
			return "redirect:/";
        }
        
        redirectAttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
        return "redirect:/";
	}
	
	@RequestMapping(value = "/snsLogin.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> SnsLogin(@RequestParam Map<String, String> params, HttpSession session) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
	    
		
		String snsId = params.get("id");
		String email = params.get("email");
		String snsType = params.get("snsType");
		
		// 소셜 로그인 회원 확인
		UserEntity snsLogin = userService.snsLogin(snsId, email, snsType);
		
		// 소셜 로그인 성공
		if(snsLogin != null){
			session.setAttribute("userId", snsLogin.getUserId());
			session.setAttribute("nickname", snsLogin.getNickname());
			map.put("email", snsLogin.getEmail());
			map.put("msg", "소셜 로그인");
			return map;
		}
		
		// 로그인 아이디만 존재(일반 로그인 유저)
		UserEntity genenalLogin = userService.emailCheck(email, null);
		
		if(genenalLogin != null) {
			map.put("email", genenalLogin.getEmail());
			map.put("msg", "일반 로그인");
			return map;
		}
		
		return map;
	}
	
	
	@RequestMapping(value = "/logout.do")
	public String Logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
	    session.invalidate();
	        
	    return "redirect:/";        
	}
	
	@RequestMapping("/join.do")
	public String Join() throws Exception {
		return "user/join";
	}

}