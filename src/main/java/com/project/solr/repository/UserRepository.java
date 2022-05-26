package com.project.solr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.solr.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	UserEntity findByEmailAndPassword(String email, String password);

	UserEntity findBySnsIdAndEmailAndSnsType(String snsId, String email, String snsType);

	UserEntity findByEmail(String email);

	UserEntity findByEmailAndSnsType(String email, String snsType);
}
