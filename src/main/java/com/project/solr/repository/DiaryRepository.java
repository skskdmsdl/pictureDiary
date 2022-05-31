package com.project.solr.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.entity.DiaryEntity;

@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, String>{

	DiaryEntity findByUserIdAndDiaryDate(int userId, Date diaryDate);

}
