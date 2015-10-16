package com.pro.dao;

import java.sql.Connection;

import com.pro.domain.Employees;
import com.pro.util.PageModel;

public interface EmployeeDao {

	/**
	 * 
	 * @param conn
	 * @param employee
	 */
	public void addEmployee(Connection conn, Employees employee)
			throws Exception;

	public void deleteEmployeeById(Connection conn, int employeeId)
			throws Exception;

	public void updateEmployee(Connection conn, Employees employee)
			throws Exception;

	public Employees findEmployeeById(Connection conn, int employeeId)
			throws Exception;

	public PageModel<Employees> queryEmployees(Connection conn,
			int currentPage, int pageSize) throws Exception;

	public Employees findEmployeeByUserId(Connection conn, int userId) throws Exception;

}