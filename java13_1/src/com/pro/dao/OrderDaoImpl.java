package com.pro.dao;

import java.sql.Connection;

import com.pro.domain.Orders;
import com.pro.util.PageModel;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	/**
	 *
	 */
	public void addOrder(Connection conn, Orders order) throws Exception {
		String sql="insert into orders(ORDER_ID,CUSTOMER_ID,EMP_ID,ORDER_DATE) values(?,?,?,?)";
		Object[] param={order.getOrderId(),order.getCustomerId(),order.getEmpId(),order.getOrderDate()};

		this.exeSql(conn, sql, param);
	}

	@Override
	public void deleteOrderById(Connection conn, int orderId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Orders findOrderById(Connection conn, int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel<Orders> findOrders(Connection conn, int currentPage,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Connection conn, Orders order) throws Exception {
		// TODO Auto-generated method stub

	}

}
