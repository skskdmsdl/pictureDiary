package com.project.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.repository.DiaryRepository;
import com.project.solr.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryRepository dr;
	
	@Override
	public DiaryEntity findDiary(int userId, String diaryDate) {
		return dr.findByUserIdAndDiaryDate(userId, diaryDate);
	}
	

	
	

}
