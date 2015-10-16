package com.pro.service;

import java.util.List;

import com.pro.domain.Category;
import com.pro.domain.OrderDetails;
import com.pro.domain.Orders;
import com.pro.util.PageModel;

public interface OrderService {

	public void addOrder(Orders order,List<OrderDetails> detailList);
	
	
	public void deleteOrderById(int orderId);
	
	public void updateOrder(Orders order);
	
	public Orders findOrderById(int orderId);
	
	public PageModel<Orders> queryOrders(int currentPage,int pageSize);
	
	public List<Orders> queryAllOrders();
}
