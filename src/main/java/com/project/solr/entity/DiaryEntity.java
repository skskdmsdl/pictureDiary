package com.project.solr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="DIARY")
@SequenceGenerator(
		name="DEARY_SEQ_GEN",
		sequenceName="DIARY_SEQ",
		initialValue=1,
		allocationSize=1
		)
@IdClass(DiaryId.class)
public class DiaryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GEN")
	@Column(name="DIARY_ID")
	int diaryId;
	@Id
	@Column(name="USER_ID")
	int userId;
	@Column(name="TITLE")
	String title;
	@Column(name="CONTENT")
	String content;
	@Column(name="CREATE_DATE", nullable = false)
	@CreationTimestamp
	Date createDate;
	@Column(name="DIARY_DATE")
	Date diaryDate;
	
	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getDiaryDate() {
		return diaryDate;
	}
	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}
	
	@Override
	public String toString() {
		return "DiaryEntity [diaryId=" + diaryId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", diaryDate=" + diaryDate + "]";
	}
	
}
