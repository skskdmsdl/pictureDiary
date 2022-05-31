package com.project.solr.service;

import java.sql.Date;

import com.project.solr.entity.DiaryEntity;

public interface DiaryService {

	DiaryEntity findDiary(int userId, Date diaryDate);

}
