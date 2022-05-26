package com.project.solr.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.solr.dto.LoginDto;
import com.project.solr.encript.SHA256;
import com.project.solr.entity.UserEntity;
import com.project.solr.repository.UserRepository;
import com.project.solr.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private UserRepository ur;

	@PostMapping(value = "/login.do")
	public String Login(LoginDto loginDto, RedirectAttributes redirectAttr, HttpSession session ) throws Exception {
		SHA256 sha256 = new SHA256();
		
		String email = loginDto.getEmail();
        String password = sha256.encrypt(loginDto.getPassword());
        
        // 계정 확인
        UserEntity user = userService.login(email, password);
        
        // 로그인 성공
        if(user != null){
        	session.setAttribute("nickname", user.getNickname());
        	session.setAttribute("userId", user.getUserId());
        	logger.info("Login User : {}", user);
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
		
		// 계정 연동 로그인 회원 확인
		UserEntity snsLogin = userService.snsLogin(snsId, email, snsType);
		
		// 계정 연동 로그인 성공
		if(snsLogin != null){
			session.setAttribute("userId", snsLogin.getUserId());
			session.setAttribute("nickname", snsLogin.getNickname());
			map.put("email", snsLogin.getEmail());
			map.put("msg", "계정 연동 로그인");
			logger.info("SNS Loign User : {}", snsLogin);

			return map;
		}
		
		// 로그인 아이디만 존재(일반 로그인 유저)
		UserEntity genenalLogin = userService.genenalEmailCheck(email, null);
		
		if(genenalLogin != null) {
			map.put("email", genenalLogin.getEmail());
			map.put("msg", "일반 로그인");
			return map;
		}
		
		map.put("msg", "계정 연동 회원가입");
		return map;
	}
	
	
	@RequestMapping(value = "/logout.do")
	public String Logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
	    session.invalidate();
	    
	    String referer = request.getHeader("referer");
	    return "redirect:" + referer;        
	}
	
	@PostMapping(value = "/join.do")
	@ResponseBody
	public HashMap<String, String> Join(
			@RequestParam Map<String, String> params, HttpServletRequest request) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		SHA256 sha256 = new SHA256();
		
		String email = params.get("email");
		String nickname = params.get("nickname");
		String password = sha256.encrypt(params.get("password"));
		
		// 계정 확인
		UserEntity userCheck = userService.emailCheck(email);
		if(userCheck != null) {
			map.put("msg", "이미 가입되어 있는 이메일입니다.");
			return map;
		}
		
		// 오늘 날짜 받아오기
		Date date = new Date();
		java.sql.Date now = new java.sql.Date(date.getTime()); // java.util.Date를 java.sql.Date로 변경
		
		UserEntity insertUser = new UserEntity();
		
		insertUser.setEmail(email);
		insertUser.setNickname(nickname);
		insertUser.setPassword(password);
		insertUser.setCreateDate(now);
		
		ur.save(insertUser);
		logger.info("Insert User : {}", insertUser);
		
		return map;
	}
	
	@PostMapping(value = "/snsJoin.do")
	@ResponseBody
	public HashMap<String, String> SnsJoin(
			@RequestParam Map<String, String> params, HttpServletRequest request) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();

		String snsId = params.get("id");
		String email = params.get("email");
		String snsType = params.get("snsType");
		String nickname = params.get("nickname");
		
		// 오늘 날짜 받아오기
		Date date = new Date();
		java.sql.Date now = new java.sql.Date(date.getTime()); // java.util.Date를 java.sql.Date로 변경
		
		// nickname이 파라미터로 넘어오지 않은 경우 
		// user update
		if("".equals(nickname) || nickname == null) {
			// 계정 확인
			UserEntity userCheck = userService.genenalEmailCheck(email, null);
			
			userCheck.setPassword(null);
			userCheck.setSnsType(snsType);
			userCheck.setSnsId(snsId);
			userCheck.setSnsConnectDate(now);
			userCheck.setModifyDate(now);
			
			ur.save(userCheck);
			map.put("msg", "계정 연동 완료. 계정으로 다시 로그인 해주세요.");
			logger.info("Update SNS User : {}", userCheck);
			
		} else {	// 계정 연동 회원가입
			UserEntity insertUser = new UserEntity();
			
			insertUser.setEmail(email);
			insertUser.setNickname(nickname);
			insertUser.setSnsType(snsType);
			insertUser.setSnsId(snsId);
			insertUser.setSnsConnectDate(now);
			insertUser.setCreateDate(now);
			
			ur.save(insertUser);
			map.put("msg", "계정 연동 완료. 계정으로 로그인을 해주세요.");
			logger.info("Insert SNS User : {}", insertUser);
		}
		
		return map;
	}

}