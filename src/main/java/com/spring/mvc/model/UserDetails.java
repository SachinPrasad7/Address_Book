package com.spring.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class UserDetails {
	@Id
	@Column(name = "userId")
	private String userId;
	@Column(name = "pass")
	private String pass;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", pass=" + pass + "]";
	}
	
	

}
