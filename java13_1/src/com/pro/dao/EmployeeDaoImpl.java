package com.pro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pro.domain.Category;
import com.pro.domain.Employees;
import com.pro.util.PageModel;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

	/**
	 * 
	 * @param conn
	 * @param employee
	 */
	public void addEmployee(Connection conn,Employees employee) throws Exception{
		String sql="insert into employees(EMP_ID,EMP_NAME,HIRE_DATE,SAL,COMM_RATE) values(seq_hehe.nextval,?,?,?,?)";
		Object[] param={employee.getEmpName(),employee.getHireDate(),employee.getSal(),employee.getCommDate()};
		
		this.exeSql(conn, sql, param);
	}
	
	public void deleteEmployeeById(Connection conn,int employeeId)throws Exception{
		String sql="delete from employees where emp_id=?";
		Object[] param={employeeId};
		
		this.exeSql(conn, sql, param);
	}
	
	public void updateEmployee(Connection conn,Employees employee)throws Exception{
		String sql="update employees set EMP_NAME=?,HIRE_DATE=?,SAL=?,COMM_RATE=? where EMP_ID=?";
		Object[] param={employee.getEmpName(),employee.getHireDate(),employee.getSal(),employee.getCommDate(),employee.getEmpId()};
	}
	
	public Employees findEmployeeById(Connection conn,int employeeId)throws Exception{
		String sql="select * from employees where emp_id=?";
		Object[] param={employeeId};
		ResultSet rs=null;
		rs=this.getRs(conn, sql, param);
		Employees emp=null;
		if(rs.next()){
			emp=new Employees();
			emp.setCommDate(rs.getInt("COMM_RATE"));
			emp.setEmpId(rs.getInt("EMP_ID"));
			emp.setEmpName(rs.getString("EMP_NAME"));
			emp.setHireDate(rs.getString("HIRE_DATE"));
			emp.setSal(rs.getDouble("SAL"));			
		}
		return emp;
	}
	
	public PageModel<Employees> queryEmployees(Connection conn, int currentPage,
			int pageSize) throws Exception {
		ResultSet rs=null;
		List<Employees> empList=new ArrayList<Employees>();
		String sql="select * from (select rownum rn,c.* from (select * from employees order by emp_id desc) c where rownum<=?) where rn>?";
		Object[] param={currentPage*pageSize,(currentPage-1)*pageSize};
		
		rs=this.getRs(conn, sql, param);
		Employees emp=null;
		while(rs.next()){
			emp=new Employees();
			emp.setCommDate(rs.getInt("COMM_RATE"));
			emp.setEmpId(rs.getInt("EMP_ID"));
			emp.setEmpName(rs.getString("EMP_NAME"));
			emp.setHireDate(rs.getString("HIRE_DATE"));
			emp.setSal(rs.getDouble("SAL"));	
			
			empList.add(emp);
		}
		PageModel<Employees> pageModel=new PageModel<Employees>();
		pageModel.setCurrentPage(currentPage);
		pageModel.setList(empList);
		pageModel.setPageSize(pageSize);
		
		int totalRecord=this.getRowCount(conn, "select count(*) from employees", null); 
		
		pageModel.setTotalRecord(totalRecord);
		
		return pageModel;
	}

	@Override
	public Employees findEmployeeByUserId(Connection conn, int userId)
			throws Exception {
		String sql="select * from employees where user_id=?";
		Object[] param={userId};
		ResultSet rs=null;
		rs=this.getRs(conn, sql, param);
		Employees emp=null;
		if(rs.next()){
			emp=new Employees();
			emp.setCommDate(rs.getInt("COMM_RATE"));
			emp.setEmpId(rs.getInt("EMP_ID"));
			emp.setEmpName(rs.getString("EMP_NAME"));
			emp.setHireDate(rs.getString("HIRE_DATE"));
			emp.setSal(rs.getDouble("SAL"));			
		}
		return emp;
	}

}
