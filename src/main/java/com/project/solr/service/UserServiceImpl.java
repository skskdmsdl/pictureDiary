package com.project.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.project.solr.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository ur;

	@Override
	public int login(String snsId, String email, String snsType) {
        // null 포인터 exception 처리 필요
		return ur.findBySnsIdAndEmailAndSnsType(snsId, email, snsType).getUserId();
	}
	
	

}
