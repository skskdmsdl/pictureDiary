package com.project.solr.service;

import java.sql.Date;
import java.util.List;

import com.project.solr.entity.DiaryEntity;

public interface DiaryService {

	DiaryEntity findDiary(int userId, Date diaryDate);

	List<DiaryEntity> findAllByUserId(int userId);

}
