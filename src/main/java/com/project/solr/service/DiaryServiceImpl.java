package com.project.solr.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.repository.DiaryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryRepository dr;
	
	@Override
	public DiaryEntity findDiary(int userId, Date diaryDate) {
		return dr.findByUserIdAndDiaryDate(userId, diaryDate);
	}

	@Override
	public List<DiaryEntity> findAllByUserId(int userId) {
		return dr.findAllByUserId(userId);
	}
	

	
}
