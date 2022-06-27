package com.project.solr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.entity.LikeEntity;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, String>{

	LikeEntity findByDiaryId(int diaryId);
	
}
