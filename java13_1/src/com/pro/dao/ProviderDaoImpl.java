package com.pro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pro.domain.Provider;
import com.pro.util.PageModel;

public class ProviderDaoImpl extends BaseDao implements ProviderDao {

	public void addProvider(Connection conn, Provider provider)
			throws Exception {
		String sql = "insert into provider(provider_id,provider_name,provider_add,provider_tel,account,email) values(seq_hehe.nextval,?,?,?,?,?)";
		Object[] param = { provider.getProviderName(), provider.getAddress(),
				provider.getTele(), provider.getAccount(), provider.getEmail() };

		this.exeSql(conn, sql, param);
	}

	public void deleteProviderById(Connection conn, int providerId)
			throws Exception {
		String sql = "delete from provider where provider_id=?";
		Object[] param = { providerId };

		this.exeSql(conn, sql, param);
	}

	public void updateProvider(Connection conn, Provider provider)
			throws Exception {
		String sql = "update provider set provider_name=?,provider_add=?,provider_tel=?,account=?,email=? where provider_id=?";
		Object[] param = { provider.getProviderName(), provider.getAddress(),
				provider.getTele(), provider.getAccount(), provider.getEmail(),
				provider.getProviderId() };

		this.exeSql(conn, sql, param);
	}

	public Provider findProviderById(Connection conn, int providerId)
			throws Exception {

		String sql = "select * from provider where provider_id=?";
		Object[] param = { providerId };
		ResultSet rs = null;
		rs = this.getRs(conn, sql, param);
		Provider provider = null;
		if (rs.next()) {
			provider = new Provider();
			provider.setAccount(rs.getString("account"));
			provider.setAddress(rs.getString("provider_add"));
			provider.setEmail(rs.getString("email"));
			provider.setProviderId(rs.getInt("provider_id"));
			provider.setProviderName(rs.getString("provider_name"));
			provider.setTele(rs.getString("provider_tel"));
		}
		return provider;
	}

	public PageModel<Provider> queryProviders(Connection conn, int currentPage,
			int pageSize) throws Exception {
		List<Provider> providerList = new ArrayList<Provider>();

		String sql = "select * from (select rownum rn,p.* from (select * from provider order by provider_id desc) p where rownum<=?) where rn>?";
		Object[] param = { currentPage * pageSize, (currentPage - 1) * pageSize };

		ResultSet rs = null;
		rs = this.getRs(conn, sql, param);
		Provider provider = null;
		while (rs.next()) {
			provider = new Provider();
			provider.setAccount(rs.getString("account"));
			provider.setAddress(rs.getString("provider_add"));
			provider.setEmail(rs.getString("email"));
			provider.setProviderId(rs.getInt("provider_id"));
			provider.setProviderName(rs.getString("provider_name"));
			provider.setTele(rs.getString("provider_tel"));

			providerList.add(provider);
		}

		PageModel<Provider> pageModel = new PageModel<Provider>();
		pageModel.setCurrentPage(currentPage);
		pageModel.setList(providerList);
		pageModel.setPageSize(pageSize);

		int totalRecord = this.getRowCount(conn,
				"select count(*) from provider", null);

		pageModel.setTotalRecord(totalRecord);

		return pageModel;
	}

	@Override
	public List<Provider> queryAllProviders(Connection conn) throws Exception {
		List<Provider> providerList = new ArrayList<Provider>();

		String sql = "select * from provider";
		Object[] param = null;

		ResultSet rs = null;
		rs = this.getRs(conn, sql, param);
		Provider provider = null;
		while (rs.next()) {
			provider = new Provider();
			provider.setAccount(rs.getString("account"));
			provider.setAddress(rs.getString("provider_add"));
			provider.setEmail(rs.getString("email"));
			provider.setProviderId(rs.getInt("provider_id"));
			provider.setProviderName(rs.getString("provider_name"));
			provider.setTele(rs.getString("provider_tel"));

			providerList.add(provider);
		}
		return providerList;
	}
}
