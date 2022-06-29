package com.project.solr.service;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.repository.DiaryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryRepository dr;

	@Override
	public List<DiaryEntity> autocomplete(int userId, String keyword) {
		return dr.findByUserIdAndTitleContainingOrUserIdAndContentContaining(userId, keyword, userId, keyword);
	}

//	@Override
//	public List<DiaryEntity> findAllByUserId(int userId) {
//		return dr.findAllByUserId(userId, Sort.by(Sort.Direction.DESC, "diaryId"));
//	}
	
	

	
}
