package com.exam.test.vo;
/**
*@author: cl
*@version : 2018年12月3日 下午4:38:04
*
*
*/
public class User {
	public String userName;
	public String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
