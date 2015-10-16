package com.pro.domain;
/**
 * 封装：将属性私有化，通过公共方法来访问私有属性
 * @author Administrator
 *
 */
public class Users {

	private int userId;
	
	private String userName;
	
	private String password;
	
	public void setUserId(int userId){
		this.userId=userId;
	}
	public int getUserId(){
		return this.userId;
	}
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
	
}
