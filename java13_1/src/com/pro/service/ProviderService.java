package com.pro.service;

import java.util.List;

import com.pro.domain.Provider;
import com.pro.util.PageModel;

public interface ProviderService {

	public void addProvider(Provider provider);

	public void deleteProviderById(int providerId);

	public void updateProvider(Provider provider);

	public Provider findProviderById(int providerId);

	public PageModel<Provider> queryProviders(int currentPage, int pageSize);
	
	public List<Provider> queryAllProvider();

}