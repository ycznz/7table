package com.pro.dao;

import java.sql.Connection;

import com.pro.domain.Orders;
import com.pro.util.PageModel;

public interface OrderDao {

	public void addOrder(Connection conn,Orders order)throws Exception;
	
	public void deleteOrderById(Connection conn,int orderId)throws Exception;
	
	public void updateOrder(Connection conn,Orders order)throws Exception;
	
	public Orders findOrderById(Connection conn,int orderId)throws Exception;
	
	public PageModel<Orders> findOrders(Connection conn,int currentPage,int pageSize)throws Exception;
}
