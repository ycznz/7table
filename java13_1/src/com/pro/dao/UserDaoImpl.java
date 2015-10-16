package com.pro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pro.domain.Users;
import com.pro.util.PageModel;

public class UserDaoImpl extends BaseDao implements UserDao {

	public void addUser(Connection conn, Users user) throws Exception {
		String sql = "insert into t_users(userId,userName,password) values(USER_SEQ.NEXTVAL,?,?)";
		// 此数组内容，对应上面sql的三个问号
		Object[] param = { user.getUserName(), user.getPassword() };

		this.exeSql(conn, sql, param);
	}

	public void updateUser(Connection conn, Users user) throws Exception {
		String sql = "update t_users set userName=?,password=? where userId=?";
		// 此数组内容，对应上面sql的三个问号
		Object[] param = { user.getUserName(), user.getPassword(),
				user.getUserId() };

		this.exeSql(conn, sql, param);
	}

	public void deleteUser(Connection conn, int userId) throws Exception {
		String sql = "delete from t_users where userId=?";
		// 此数组内容，对应上面sql的三个问号
		Object[] param = { userId };

		this.exeSql(conn, sql, param);
	}

	public List<Users> queryUsers(Connection conn) throws Exception {
		String sql = "select * from t_users order by userId desc";
		Object[] param = null;
		// 创建装用户对象的集合容器
		List<Users> userList = new ArrayList<Users>();

		ResultSet rs = null;
		rs = this.getRs(conn, sql, param);

		while (rs.next()) {
			int userId = rs.getInt("userId");
			String userName = rs.getString("userName");
			String password = rs.getString("password");

			Users user = new Users();
			user.setPassword(password);
			user.setUserId(userId);
			user.setUserName(userName);
			// 注意。用add方法。放数据
			userList.add(user);// 将赋好值的user对象加入到容器对象中
		}
		return userList;
	}

	public PageModel<Users> queryPageUsers(Connection conn, int currentPage,
			int pageSize) throws Exception {
		String sql = "select * from t_user limit ?,?";// 如果oracle不会用limit，此sql要重写。
		Object[] param = { (currentPage - 1) * pageSize, pageSize };
		// 创建装用户对象的集合容器
		List<Users> userList = new ArrayList<Users>();

		ResultSet rs = null;
		rs = this.getRs(conn, sql, param);

		while (rs.next()) {
			int userId = rs.getInt("userId");
			String userName = rs.getString("userName");
			String password = rs.getString("password");

			Users user = new Users();
			user.setPassword(password);
			user.setUserId(userId);
			user.setUserName(userName);
			// 注意。用add方法。放数据
			userList.add(user);// 将赋好值的user对象加入到容器对象中
		}

		// 到此时，userList集合已经装满了数据。那我们就把这个集合，放入pageModel中。
		PageModel<Users> pageModel = new PageModel<Users>();
		pageModel.setCurrentPage(currentPage);
		pageModel.setList(userList);
		pageModel.setPageSize(pageSize);

		String sq = "select count(*) from t_user";
		int totalRecord = this.getRowCount(conn, sql, param);
		pageModel.setTotalRecord(totalRecord);

		return pageModel;
	}

	@Override
	public Users login(Connection conn, Users user) throws Exception {
		String sql = "select * from t_users where user_Name=? and pwd=?";
		Object[] param = { user.getUserName(), user.getPassword() };
		ResultSet rs = null;

		rs = this.getRs(conn, sql, param);
		Users us = null;
		if (rs.next()) {
			us = new Users();
			us.setUserName(rs.getString("user_Name"));
			us.setPassword(rs.getString("pwd"));
			us.setUserId(rs.getInt("user_id"));
		}
		return us;
	}

	@Override
	public Users findUserById(Connection conn, int userId) throws Exception {
		String sql = "select * from t_users where userId=?";
		Object[] param = { userId };
		ResultSet rs = null;

		rs = this.getRs(conn, sql, param);
		Users us = null;
		if (rs.next()) {
			us = new Users();
			us.setUserName(rs.getString("userName"));
			us.setPassword(rs.getString("password"));
			us.setUserId(rs.getInt("userId"));
		}
		return us;
	}
}
