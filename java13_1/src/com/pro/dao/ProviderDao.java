package com.pro.dao;

import java.sql.Connection;
import java.util.List;

import com.pro.domain.Provider;
import com.pro.util.PageModel;

public interface ProviderDao {

	public void addProvider(Connection conn, Provider provider)
			throws Exception;

	public void deleteProviderById(Connection conn, int providerId)
			throws Exception;

	public void updateProvider(Connection conn, Provider provider)
			throws Exception;

	public Provider findProviderById(Connection conn, int providerId)
			throws Exception;

	public PageModel<Provider> queryProviders(Connection conn, int currentPage,
			int pageSize) throws Exception;

	public List<Provider> queryAllProviders(Connection conn)throws Exception;

}