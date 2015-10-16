package com.pro.domain;

/**
 *  
 *ORDER_ID     NUMBER(6)                        NOT NULL,
  CUSTOMER_ID  NUMBER(6),
  EMP_ID       NUMBER(6),
  ORDER_DATE   VARCHAR2(30 BYTE)
 * @author Administrator
 *
 */
public class Orders {

	private int orderId;
	
	private int customerId;
	
	private int empId;
	
	private String orderDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
