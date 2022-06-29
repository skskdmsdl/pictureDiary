package com.project.solr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.entity.DiaryImageEntity;

@Repository
public interface DiaryImageRepository extends JpaRepository<DiaryImageEntity, String>{

	List<DiaryImageEntity> findAll();
	
	Optional<DiaryImageEntity> findByDiaryId(int diaryId);
}
