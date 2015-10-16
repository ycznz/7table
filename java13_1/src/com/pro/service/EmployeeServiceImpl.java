package com.pro.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.pro.dao.EmployeeDao;
import com.pro.dao.EmployeeDaoImpl;
import com.pro.domain.Employees;
import com.pro.util.DbHelper;
import com.pro.util.PageModel;

public class EmployeeServiceImpl implements EmployeeService {

	public void addEmployee(Employees employee) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			EmployeeDao employeeDao=new EmployeeDaoImpl();
			employeeDao.addEmployee(conn, employee);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteEmployeeById(int employeeId) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			EmployeeDao employeeDao=new EmployeeDaoImpl();
			employeeDao.deleteEmployeeById(conn, employeeId);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Employees findEmployeeById(int employeeId) {
		Connection conn = null;
		Employees employees=null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			EmployeeDao employeeDao=new EmployeeDaoImpl();
			employees = employeeDao.findEmployeeById(conn, employeeId);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	public PageModel<Employees> queryEmployees(int currentPage, int pageSize) {
		return null;
	}

	public void updateEmployee(Employees employee) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			EmployeeDao employeeDao=new EmployeeDaoImpl();
			employeeDao.updateEmployee(conn, employee);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Employees findEmployeeByUserId(int userId) {
		Connection conn = null;
		Employees employees=null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			EmployeeDao employeeDao=new EmployeeDaoImpl();
			employees = employeeDao.findEmployeeByUserId(conn,userId);
			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

}
