package com.pro.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pro.dao.OrderDao;
import com.pro.dao.OrderDaoImpl;
import com.pro.dao.OrderDetailDao;
import com.pro.dao.OrderDetailDaoImpl;
import com.pro.domain.OrderDetails;
import com.pro.domain.Orders;
import com.pro.util.DbHelper;
import com.pro.util.PageModel;

public class OrderServiceImpl implements OrderService {

	@Override
	public void deleteOrderById(int orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders findOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> queryAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel<Orders> queryOrders(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Orders order) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addOrder(Orders order, List<OrderDetails> detailList) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交
			//添加订单
			OrderDao orderDao = new OrderDaoImpl();
			orderDao.addOrder(conn, order);
			//添加明细
			OrderDetailDao odd=new OrderDetailDaoImpl();
			odd.addOrderDetail(conn, detailList);			

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

	

}
