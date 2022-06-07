package com.project.solr.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="DIARY_IMAGE")
public class DiaryImageEntity {

	@Id
	@Column(name="DIARY_ID")
	int diaryId;
	@Column(name="CREATE_DATE")
	Date createDate;
	@Column(name="REAL_NAME")
	String realName;
	@Column(name="FILE_NAME")
	String fileName;
	@Column(name="PATH")
	String path;
	
	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "DiaryImageEntity [diaryId=" + diaryId + ", createDate=" + createDate + ", realName=" + realName
				+ ", fileName=" + fileName + ", path=" + path + "]";
	}

}
