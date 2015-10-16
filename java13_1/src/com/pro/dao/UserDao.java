package com.pro.dao;

import java.sql.Connection;
import java.util.List;

import com.pro.domain.Users;
import com.pro.util.PageModel;

public interface UserDao {
	
	public Users login(Connection conn, Users user)throws Exception;

	
	public Users findUserById(Connection conn,int userId)throws Exception;
	/**
	 * 添加用户
	 * @param conn
	 * @param user
	 * @throws Exception
	 */
	public  void addUser(Connection conn, Users user) throws Exception;

	/**
	 * 修改
	 * @param conn
	 * @param user
	 * @throws Exception
	 */
	public  void updateUser(Connection conn, Users user)
			throws Exception;

	/**
	 * 删除
	 * @param conn
	 * @param user
	 * @throws Exception
	 */
	public  void deleteUser(Connection conn, int userId)
			throws Exception;

	/**
	 * 查询所有用户。将结果集中的记录，一条一条的加入到集合中。
	 * @param conn
	 * @throws Exception
	 */
	public  List<Users> queryUsers(Connection conn) throws Exception;

	/**
	 * 分页
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public  PageModel<Users> queryPageUsers(Connection conn,
			int currentPage, int pageSize) throws Exception;

}