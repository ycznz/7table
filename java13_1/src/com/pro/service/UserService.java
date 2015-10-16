package com.pro.service;

import java.sql.Connection;
import java.util.List;

import com.pro.domain.Users;

public interface UserService {

	public Users queryUserById(int userId);
	/**
	 * 查所有用户
	 * @return
	 */
	public List<Users> findAllUser();

	public void saveUser(Users user);

	/**
	 * 
	 * @param user
	 */
	public void editUser(Users user);

	public void removeUser(int userId);
	
	public Users login( Users user) ;

}