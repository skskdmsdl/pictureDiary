package com.project.solr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.entity.DiaryImageEntity;

@Repository
public interface DiaryImageRepository extends JpaRepository<DiaryImageEntity, String>{

	List<DiaryImageEntity> findAll();
	
	DiaryImageEntity findByDiaryId(int diaryId);
}
