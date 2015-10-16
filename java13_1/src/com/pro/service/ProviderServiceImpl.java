package com.pro.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pro.dao.ProviderDao;
import com.pro.dao.ProviderDaoImpl;
import com.pro.domain.Provider;
import com.pro.util.DbHelper;
import com.pro.util.PageModel;

public class ProviderServiceImpl implements ProviderService {
	public void addProvider(Provider provider){
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProviderDao providerDao=new ProviderDaoImpl();
			providerDao.addProvider(conn, provider);

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

	public void deleteProviderById(int providerId){
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProviderDao providerDao=new ProviderDaoImpl();
			providerDao.deleteProviderById(conn, providerId);

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

	public void updateProvider( Provider provider){
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProviderDao providerDao=new ProviderDaoImpl();
			providerDao.updateProvider(conn, provider);
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

	public Provider findProviderById( int providerId){
		Connection conn = null;
		Provider provider =null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProviderDao providerDao=new ProviderDaoImpl();
			provider = providerDao.findProviderById(conn, providerId);

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

		return provider;
	}

	public PageModel<Provider> queryProviders(int currentPage,
			int pageSize) {
		Connection conn = null;
		PageModel<Provider> pageModel =null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProviderDao providerDao=new ProviderDaoImpl();
			pageModel = providerDao.queryProviders(conn, currentPage, pageSize);
			
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

		return pageModel;
	}

	@Override
	public List<Provider> queryAllProvider() {
		Connection conn = null;
		List<Provider> providerList =null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProviderDao providerDao=new ProviderDaoImpl();
			providerList = providerDao.queryAllProviders(conn);
			
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

		return providerList;
	}
}
