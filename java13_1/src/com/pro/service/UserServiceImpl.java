package com.pro.service;

import java.sql.Connection;
import java.util.List;

import com.pro.dao.UserDao;
import com.pro.dao.UserDaoImpl;
import com.pro.domain.Users;
import com.pro.util.DbHelper;

public class UserServiceImpl implements UserService {

	/**
	 * 查所有用户
	 * @return
	 */
	public List<Users> findAllUser(){
		UserDao userDao=new UserDaoImpl();
		List<Users> userList=null;
		try {
			Connection conn=DbHelper.getConn();
			
			userList = userDao.queryUsers(conn);
			
			DbHelper.closeAll(conn);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询所有失败");
		}
		
		return userList;
	}
	
	public void saveUser(Users user){
		
		UserDao userDao=new UserDaoImpl();
		
		try {
			//得到连接对象
			Connection conn=DbHelper.getConn();
			//调用dao的添加方法
			userDao.addUser(conn, user);		
			
			DbHelper.closeAll(conn);
		} catch (Exception e) {
			System.out.println("添加操作失败。");
			e.printStackTrace();			
		}		
	}
	/**
	 * 
	 * @param user
	 */
	public void editUser(Users user){
		UserDao userDao=new UserDaoImpl();
		try {
			//得到连接对象
			Connection conn=DbHelper.getConn();
			//调用dao的修改方法
			userDao.updateUser(conn, user);		
			
			DbHelper.closeAll(conn);
		} catch (Exception e) {
			System.out.println("修改操作失败。");
			e.printStackTrace();			
		}	
	}
	
	public void removeUser(int userId){
		UserDao userDao=new UserDaoImpl();
		try {
			//得到连接对象
			Connection conn=DbHelper.getConn();
			//调用dao的修改方法
			userDao.deleteUser(conn, userId);	
			
			DbHelper.closeAll(conn);
		} catch (Exception e) {
			System.out.println("删除操作失败。");
			e.printStackTrace();			
		}	
	}

	@Override
	public Users login(Users user) {
		UserDao userDao=new UserDaoImpl();
		Users us=null;
		try {
			//得到连接对象
			Connection conn=DbHelper.getConn();
			//调
			us=userDao.login(conn, user);	
			
			DbHelper.closeAll(conn);
		} catch (Exception e) {
			System.out.println("删除操作失败。");
			e.printStackTrace();			
		}	
		return us;
	}

	/**
	 * 查用户，根据id
	 */
	public Users queryUserById(int userId) {
		UserDao userDao=new UserDaoImpl();
		Users us=null;
		try {
			//得到连接对象
			Connection conn=DbHelper.getConn();
			//调
			us=userDao.findUserById(conn, userId);	
			
			DbHelper.closeAll(conn);
		} catch (Exception e) {
			System.out.println("查单个对象失败。");
			e.printStackTrace();			
		}	
		return us;
	}
}
