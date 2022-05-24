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
	public String Login(LoginDto loginDto, RedirectAttributes redirectAttr) throws Exception {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        
        // 계정 확인
        UserEntity login = userService.login(email, password);
        
        // 소셜 로그인 성공
        if(login != null){
			//map.put("email", login.getEmail());
			return "redirect:/";
        }
        
        redirectAttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
        return "redirect:/";
	}
	
	@RequestMapping(value = "/snsLogin.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> SnsLogin(@RequestParam Map<String, String> params, HttpServletResponse response, HttpServletRequest request) throws Exception {
//		System.out.println(params.get("id")); //Object여서 형 변환
//      System.out.println(params.get("email"));
		HashMap<String, String> map = new HashMap<String, String>();
		
		String snsId = params.get("id");
		String email = params.get("email");
		String snsType = params.get("snsType");
		
		// 소셜 로그인 회원 확인
		UserEntity snsLogin = userService.snsLogin(snsId, email, snsType);
		
		// 소셜 로그인 성공
		if(snsLogin != null){
			HttpSession session = request.getSession();
			session.setAttribute("id", snsLogin);
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
	
	@RequestMapping("/join.do")
	public String Join() throws Exception {
		return "user/join";
	}

}