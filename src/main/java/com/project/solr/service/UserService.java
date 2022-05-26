package com.project.solr.service;

import com.project.solr.entity.UserEntity;

public interface UserService {

	UserEntity login(String email, String password);
	
	UserEntity snsLogin(String snsId, String email, String snsType);

	UserEntity emailCheck(String email);
	
	UserEntity genenalEmailCheck(String email, String snsType);

}
