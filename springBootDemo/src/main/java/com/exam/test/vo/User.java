package com.exam.test.vo;
/**
*@author: cl
*@version : 2018年12月3日 下午4:38:04
*
*
*/
public class User {
	public Integer id;
	public String username;
	public String password;
	public Integer userid;

	public Integer getId() {
		return id;
	}

	public Integer getUserId() {
		return userid;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id="+id+",username=" + username + ", password=" + password +",userid="+userid+"]";
	}


}
