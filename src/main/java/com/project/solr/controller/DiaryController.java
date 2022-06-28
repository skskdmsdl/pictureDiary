package com.project.solr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.solr.dto.DiaryDto;
import com.project.solr.entity.DiaryEntity;
import com.project.solr.entity.DiaryImageEntity;
import com.project.solr.repository.DiaryImageRepository;
import com.project.solr.repository.DiaryRepository;

@Controller
@RequestMapping("/diary")
public class DiaryController {
	
	@Autowired
	private DiaryRepository dr;
	
	@Autowired
	private DiaryImageRepository dir;
	
	@RequestMapping("/detail.do")
	public String Detail(@RequestParam int diaryId, DiaryDto diary) throws Exception {
		
		DiaryEntity diaryInfo = dr.findByDiaryId(diaryId);
		DiaryImageEntity diaryImageInfo = new DiaryImageEntity();
		try {
			diaryImageInfo = dir.findByDiaryId(diaryId);
			diary.setPath(diaryImageInfo.getPath());
		}catch(Exception e) {
			System.out.println(e);
		}
		
		diary.setTitle(diaryInfo.getTitle());
		diary.setContent(diaryInfo.getContent());
		diary.setDiaryDate(diaryInfo.getDiaryDate());
		
		return "diary/detail";
	}
	
	@RequestMapping("/likeList.do")
	public ModelAndView LikeList(ModelAndView mav, HttpSession session) throws Exception {
		
		try {
			
			int userId = (int)session.getAttribute("userId");
		}catch (Exception e){
			mav.setViewName("redirect:/");

			return mav;
		}
		
		mav.setViewName("diary/like");

		
		return mav;
	}
	
	@RequestMapping(value = "/likeUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public String LikeUpdate(ModelAndView mav, @RequestParam int diaryId, @RequestParam int userId) throws Exception {
		
		DiaryEntity bookmark = dr.findByDiaryId(diaryId);
//		String current = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		Date current = new Date();	
		
		if(bookmark.getBookmark() == null) {
			bookmark.setBookmark("1");
			bookmark.setModifyDate(current);
			dr.save(bookmark);
		}else {
			bookmark.setBookmark(null);
			bookmark.setModifyDate(current);
			dr.save(bookmark);
		}
		
		return "dd";
	}
	
//	@RequestMapping(value = "/likeUpdate.do", method = RequestMethod.POST)
//	@ResponseBody
//	public String LikeUpdate(ModelAndView mav, @RequestParam int diaryId, @RequestParam int userId) throws Exception {
//		
//		LikeEntity like = lr.findByDiaryId(diaryId);
//		
//		if(like == null) {
//			LikeEntity insertLike = new LikeEntity();
//			insertLike.setDiaryId(diaryId);
//			insertLike.setUserId(userId);
//			lr.save(insertLike);
//		}else {
//			lr.delete(like);
//		}
//		
//		return "dd";
//	}

	
}