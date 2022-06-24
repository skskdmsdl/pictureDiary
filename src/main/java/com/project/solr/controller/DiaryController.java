package com.project.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.solr.dto.DiaryDto;
import com.project.solr.entity.DiaryEntity;
import com.project.solr.entity.DiaryImageEntity;
import com.project.solr.repository.DiaryImageRepository;
import com.project.solr.repository.DiaryRepository;
import com.project.solr.repository.UserRepository;

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

}