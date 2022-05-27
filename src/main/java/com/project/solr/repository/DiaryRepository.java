package com.project.solr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.entity.UserEntity;

@Repository
public interface DiaryRepository extends JpaRepository<UserEntity, String>{
	
}
