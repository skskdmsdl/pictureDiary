package com.project.solr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.repository.DiaryImageRepository;
import com.project.solr.repository.DiaryRepository;
import com.project.solr.service.DiaryService;

@Controller
public class MainController {
	
	@Autowired
	private DiaryRepository dr;
	
	@Autowired
	private DiaryImageRepository dir;
	
	@Autowired
    private DiaryService diaryService;
	
	@RequestMapping("/")
	public String Main(HttpServletRequest request, HttpSession session) throws Exception {
		
		session = request.getSession();

		try {
			
			int userId = (int)session.getAttribute("userId");
		}catch(Exception e){
			return "/main";
 
		}
		int userId = (int)session.getAttribute("userId");
		// diary 정보 전체 가져오기
		
		List<DiaryEntity> diaryList = diaryService.findAllByUserId(userId);
		
		System.out.println(session.getAttribute("userId"));
		System.out.println(diaryList);
		
		
		return "/main";
	}

}
