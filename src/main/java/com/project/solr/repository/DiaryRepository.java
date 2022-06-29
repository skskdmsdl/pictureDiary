package com.project.solr.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.dto.DiaryDto;
import com.project.solr.entity.DiaryEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, String>{
	
//	List<DiaryEntity> findAllByUserId(int userId, Sort sort);
	
//	Page<DiaryEntity> findAllByUserId(int userId, Pageable pageable);

	List<DiaryEntity> findAllByUserId(int userId, Pageable pageable);
	
	List<DiaryEntity> findCountByUserId(int userId);

	List<DiaryEntity> findByUserIdAndTitleContainingOrUserIdAndContentContaining(int userId1, String title, int userId2, String content);

	DiaryEntity findByDiaryId(int diaryId);

	List<DiaryEntity> findByUserIdAndBookmark(int userId, String string);
}
