package com.project.solr.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.project.solr.repository.DiaryRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/write")
public class WriteController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiaryRepository dr;
	
	@RequestMapping("/write.do")
	public String Write() throws Exception {
		return "write/write";
	}

	@PostMapping(value = "/writeDiary.do")
	public String WriteDiary(
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam String diaryDate,
			@RequestParam("file") MultipartFile diaryFile,
			HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		System.out.println("userId"+userId);
		
		String path = request.getServletContext().getRealPath("/upload/diaryImage/");
		System.out.println("path : " + path);
		System.out.println("diaryFile : " + diaryFile);
		
		/*
		 * File file = new File(path, uploadFileName); if(!file.exists()) file.mkdirs();
		 */
			
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
		} catch (IllegalStateException | IOException e) {
			System.out.println("파일 업로드 실패");
			e.printStackTrace();
		}
			
		  
		
		
		String referer = request.getHeader("referer");

        return "redirect:" + referer;
	}
}
