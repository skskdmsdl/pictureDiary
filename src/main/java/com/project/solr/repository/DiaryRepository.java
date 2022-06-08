package com.project.solr.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.entity.DiaryEntity;

@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, String>{

//	List<DiaryEntity> findAllByUserId(int userId, Sort sort);

	List<DiaryEntity> findAllByUserId(int userId, Pageable pageable);
}
