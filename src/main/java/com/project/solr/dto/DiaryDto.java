package com.project.solr.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class DiaryDto {
	private int diaryId;
	private int userId;
	private String title;
	private String content;
	private Date createDate;
	private Date diaryDate;
	private String bookmark;
	private String path;
	
	
}
