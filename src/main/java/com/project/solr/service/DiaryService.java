package com.project.solr.service;

import java.sql.Date;
import java.util.List;

import com.project.solr.entity.DiaryEntity;

public interface DiaryService {

	List<DiaryEntity> autocomplete(int userId, String keyword);

//	List<DiaryEntity> findAllByUserId(int userId);

}
