package com.project.solr.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

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
@Table(name="DIARY_IMAGE")
public class DiaryImageEntity {

	@Id
	@Column(name="DIARY_ID")
	int diaryId;
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	Date createDate;
	@Column(name="REAL_NAME")
	String realName;
	@Column(name="FILE_NAME")
	String fileName;
	@Column(name="PATH")
	String path;
	
}
