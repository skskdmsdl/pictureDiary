package com.project.solr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.solr.common.Utils;
import com.project.solr.entity.DiaryEntity;
import com.project.solr.entity.DiaryImageEntity;
import com.project.solr.repository.DiaryRepository;
import com.project.solr.service.DiaryImageService;

@Controller
public class MainController {
	
	@Autowired
	private DiaryRepository dr;
	
	@Autowired
	private DiaryImageService diaryImageService;
	
	@RequestMapping(value = {"/", "main.do"})
	public ModelAndView Main(ModelAndView mav, 
							HttpServletRequest request, 
							HttpSession session, 
							@RequestParam(required = false, defaultValue="1") int cPage) throws Exception {
		
		session = request.getSession();
		
		try {
			int userId = (int)session.getAttribute("userId");
		}catch(Exception e){

			mav.setViewName("/main");
			return mav;
		}
		int userId = (int)session.getAttribute("userId");
		
		// diary 정보 전체 가져오기
		//diaryList = diaryList.stream().sorted(Comparator.comparing(DiaryEntity::getDiaryDate).reversed()).collect(Collectors.toList());
		List<DiaryEntity> diaryList = dr.findAllByUserId(userId, PageRequest.of(cPage-1, 5, Sort.by("diaryDate").descending().and(Sort.by("diaryId").descending())));
		
//		Page<DiaryEntity> diaryList1 = dr.findAllByUserId1(userId, PageRequest.of(page-1, 5, Sort.by("diaryDate").descending().and(Sort.by("diaryId").descending())));
		
		//전체컨텐츠수 구하기
		List<DiaryEntity> totalList = dr.findCountByUserId(userId); 
		int totalContents = totalList.size(); 
		String url = request.getRequestURI() + "?";
		String pageBar = Utils.getPageBarHtml(cPage, 5, totalContents, url);

		// diaryImage 정보 전체 가져오기
		List<DiaryImageEntity> diaryImageList = diaryImageService.findAll();
		
		mav.addObject("diaryList", diaryList);
		mav.addObject("diaryImageList", diaryImageList);
		mav.addObject("cPage", cPage);
		mav.addObject("totalContents", totalContents);
		mav.addObject("pageBar", pageBar);
		mav.setViewName("/main");
		return mav;
	}

}
