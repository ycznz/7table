package com.pro.service;

import java.sql.Connection;

import com.pro.domain.Employees;
import com.pro.util.PageModel;

public interface EmployeeService {

	public void addEmployee( Employees employee);

	public void deleteEmployeeById( int employeeId);

	public void updateEmployee( Employees employee);

	public Employees findEmployeeById( int employeeId);

	public PageModel<Employees> queryEmployees(
			int currentPage, int pageSize);
	
	public Employees findEmployeeByUserId( int userId); 
}
