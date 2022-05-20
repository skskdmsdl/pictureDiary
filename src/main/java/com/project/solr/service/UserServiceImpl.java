package com.project.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.solr.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository ur;

	@Override
	public int login(String snsId, String email, String snsType)  {
		// TODO Auto-generated method stub
		return ur.findBySnsIdAndEmailAndSnsType(snsId, email, snsType).getUserId();
	}
	
	

}
