package com.project.solr.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.entity.DiaryImageEntity;
import com.project.solr.repository.DiaryImageRepository;
import com.project.solr.repository.DiaryRepository;
import com.project.solr.service.DiaryImageService;
import com.project.solr.service.DiaryService;

@Controller
public class MainController {
	
	@Autowired
	private DiaryRepository dr;
	
	@Autowired
	private DiaryImageRepository dir;
	
	@Autowired
    private DiaryService diaryService;
	
	@Autowired
	private DiaryImageService diaryImageService;
	
	@RequestMapping(value = {"/", "main.do"})
	public ModelAndView Main(ModelAndView mav, HttpServletRequest request, HttpSession session, @RequestParam(required = false, defaultValue="1") int page) throws Exception {
		
		session = request.getSession();
		
		try {
			int userId = (int)session.getAttribute("userId");
		}catch(Exception e){

			
			mav.setViewName("/main");
			return mav;
		}
		int userId = (int)session.getAttribute("userId");
		
		// diary 정보 전체 가져오기
		//List<DiaryEntity> diaryList = diaryService.findAllByUserId(userId);
		List<DiaryEntity> diaryList = dr.findAllByUserId(userId, PageRequest.of(page-1, 5, Sort.by("diaryDate").descending().and(Sort.by("diaryId").descending())));
		//diaryList = diaryList.stream().sorted(Comparator.comparing(DiaryEntity::getDiaryDate).reversed()).collect(Collectors.toList());
		
		System.out.println("결과 출력2"+diaryList);
		// diaryImage 정보 전체 가져오기
		List<DiaryImageEntity> diaryImageList = diaryImageService.findAll();
		
		mav.addObject("diaryList", diaryList);
		mav.addObject("diaryImageList", diaryImageList);
		mav.addObject("page", page);
		mav.setViewName("/main");
		return mav;
	}

}
