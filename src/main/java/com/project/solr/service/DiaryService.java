package com.project.solr.service;

import com.project.solr.entity.DiaryEntity;

public interface DiaryService {

	DiaryEntity findDiary(int userId, String diaryDate);

}
