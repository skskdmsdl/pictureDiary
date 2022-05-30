package com.project.solr.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.entity.DiaryImageEntity;
import com.project.solr.repository.DiaryImageRepository;
import com.project.solr.repository.DiaryRepository;
import com.project.solr.service.DiaryService;
import com.project.solr.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/write")
public class WriteController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiaryRepository dr;
	
	@Autowired
	private DiaryImageRepository dir;
	
	@Autowired
    private DiaryService diaryService;
	
	@RequestMapping("/write.do")
	public String Write() throws Exception {
		return "write/write";
	}

	@PostMapping(value = "/writeDiary.do")
	public String WriteDiary(
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam String diaryDate,
			@RequestParam(value ="file", required=false) MultipartFile diaryFile,
			HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		Date date = Date.valueOf(diaryDate);
		System.out.println("userId"+userId);
		
		DiaryEntity diary = diaryService.findDiary(userId, diaryDate);
		
		if(diary == null) {
			
		} else {
			
			diary.setUserId(userId);
			diary.setTitle(title);
			diary.setContent(content);
			diary.setDiaryDate(date);
			
			int diaryId = dr.save(diary).getDiaryId();
			
			System.out.println("diaryId"+diaryId);
			if(diaryFile.getSize() > 0) {
				
				DiaryImageEntity diaryImage = new DiaryImageEntity(); 
				
				String path = request.getServletContext().getRealPath("/upload/diaryImage/");
				System.out.println("path : " + path);
				System.out.println("diaryFile : " + diaryFile);
				
				// 원본 파일명
				String originalFileName = diaryFile.getOriginalFilename();
				
				// upload 파일명 설정
				UUID uuid = UUID.randomUUID();
				String uploadFileName = uuid.toString() +"_"+ originalFileName;
				
				// 파일 upload
				File saveFile = new File(path, uploadFileName);
				try {
					diaryFile.transferTo(saveFile);
					System.out.println("파일 업로드 성공");
					
					
					diaryImage.setDiaryId(diaryId);
					diaryImage.setRealName(originalFileName);
					diaryImage.setFileName(uploadFileName);
					diaryImage.setPath(path+uploadFileName);
					
					dir.save(diaryImage);
				} catch (IllegalStateException | IOException e) {
					System.out.println("파일 업로드 실패");
					e.printStackTrace();
				}
			}
		}
			
		String referer = request.getHeader("referer");

        return "redirect:" + referer;
	}
}
