package com.project.solr.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class UserEntity {

	@Id
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
	String snsConnectDate;
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
	public String getSnsConnectDate() {
		return snsConnectDate;
	}
	public void setSnsConnectDate(String snsConnectDate) {
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
