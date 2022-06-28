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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
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
	@Column(name="BOOKMARK")
	String bookmark;
	@Column(name="MODIFY_DATE", nullable = false)
	@CreationTimestamp
	Date modifyDate;

}
