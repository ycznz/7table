package com.pro.domain;

public class Provider {

	private int providerId;
	
	private String providerName;
	
	private String Address;
	
	private String tele;
	
	private String account;
	
	private String email;

	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provider(int providerId, String providerName, String address,
			String tele, String account, String email) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		Address = address;
		this.tele = tele;
		this.account = account;
		this.email = email;
	}

	public Provider(String providerName, String address, String tele,
			String account, String email) {
		super();
		this.providerName = providerName;
		Address = address;
		this.tele = tele;
		this.account = account;
		this.email = email;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
