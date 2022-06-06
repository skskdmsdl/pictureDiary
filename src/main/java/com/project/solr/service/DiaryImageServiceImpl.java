package com.project.solr.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.solr.entity.DiaryEntity;
import com.project.solr.entity.DiaryImageEntity;
import com.project.solr.repository.DiaryImageRepository;
import com.project.solr.repository.DiaryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DiaryImageServiceImpl implements DiaryImageService{

	@Autowired
	private DiaryImageRepository dir;
	
	@Override
	public List<DiaryImageEntity> findAll() {
		return dir.findAll();
	}
	
}
