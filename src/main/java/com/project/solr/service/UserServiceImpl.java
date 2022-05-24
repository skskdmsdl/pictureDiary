package com.project.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.project.solr.entity.UserEntity;
import com.project.solr.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository ur;

	@Override
	public UserEntity login(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
	}
	
	@Override
	public UserEntity snsLogin(String snsId, String email, String snsType) {
		return ur.findBySnsIdAndEmailAndSnsType(snsId, email, snsType);
	}

	@Override
	public UserEntity emailCheck(String email, String snsType) {
		return ur.findByEmailAndSnsType(email, snsType);
	}

	
	

}
