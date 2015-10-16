package com.pro.util;

import java.util.ArrayList;
import java.util.List;

public class PageModel<T> {

	//分页要显示的数据
	private List<T> list;
	
	//当前面
	private int currentPage;
	
	//页显示行数
	private int pageSize;
	
	//总记录数
	private int totalRecord;
	
	/**
	 * 总页数
	 */
	public int getTotalPage(){
		return (totalRecord+pageSize-1)/pageSize;
	}

	
	/**
	 * 首页
	 */
	public int getPageFirst(){
		return 1;
	}
	/**
	 * 上一页
	 */
	public int getPageUp(){
		if(this.getCurrentPage()<=1){
			return 1;
		}
		return this.getCurrentPage()-1;
	}
	
	/**
	 * 下一页
	 */
	public int getPageDown(){
		if(this.getCurrentPage()>=this.getTotalPage()){
			return this.getTotalPage();
		}
		return this.currentPage+1;
	}
	
	/**
	 * 尾页
	 */
	public int getPageLast(){
		return this.getTotalPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	public int getCurrentPage() {
		return currentPage;
	}

	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
}
