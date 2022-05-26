package com.project.solr.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
@SequenceGenerator(
		name="USER_SEQ_GEN",
		sequenceName="USER_SEQ",
		initialValue=1,
		allocationSize=1
		)
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GEN")
	@Column(name="USER_ID")
	int userId;
	@Column(name="EMAIL")
	String email;
	@Column(name="PASSWORD")
	String password;
	@Column(name="NICKNAME")
	String nickname;
	@Column(name="SNS_TYPE")
	String snsType;
	@Column(name="SNS_ID")
	String snsId;
	@Column(name="SNS_CONNECT_DATE")
	Date snsConnectDate;
	@Column(name="CREATE_DATE")
	Date createDate;
	@Column(name="MODIFY_DATE")
	Date modifyDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSnsType() {
		return snsType;
	}
	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
	public Date getSnsConnectDate() {
		return snsConnectDate;
	}
	public void setSnsConnectDate(Date snsConnectDate) {
		this.snsConnectDate = snsConnectDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	

}
