package com.jpg.hebei.model;

import java.util.List;
public class PageBean {

	private List<Information> list; 
	private int allRow;//总记录数
	private int totalPage;//总页数
	private int currentPage;//当前页
	private int pageSize;//每页的记录数
	
	private boolean isFristPage;//是否为第一页
	private boolean isLastPage;//是否为最后一页
	private boolean hasPreviousPage;//是否有前一页
	private boolean hasNextPage;//是否有后一页
	
	
	/*
	 * 初始化分页信息
	 */
	public void init(){
		this.isFristPage=isFristPage();
		this.isLastPage= isLastPage();
		this.hasPreviousPage=HasPreviousPage();
		this.hasNextPage=HasNextPage();
	}
	
	
	
	public boolean isFristPage() {
		return (currentPage==1);
	}
	public boolean isLastPage() {
		return currentPage== totalPage;
	}
	public boolean HasPreviousPage() {
		return currentPage !=1;
	}
	public boolean HasNextPage() {
		return currentPage != totalPage;
	}
	
	/**
	 * 计算总页数  静态方法
	 * @param pageSize  每页的记录数
	 * @param allRow  总记录数
	 * @return 总页数
	 */
	
	public static int countTotalPage(final int pageSize,final int allRow){
		int totalPage = allRow % pageSize ==0 ? allRow/pageSize :allRow /pageSize +1;
		return totalPage;
	}
	
	/**
	 * 计算当前页开始的记录
	 * @param pageSize 每页记录数
	 * @param currentPage 当前第几页
	 * @return 当前页开始记录号
	 */
	public static int countOffset(final int pageSize,int currentPage){
		final int offset = pageSize * (currentPage - 1);
		return offset;
	}
	/**
	 * 计算当前页，若为0或者请求的URL中没有“?page = ”则用1代替
	 * @param page 传入的参数（可能为空，即0  则返回1）
	 * @return
	 */
	public static int countCurrentPage(int page){
		final int curPage =(page==0 ? 1 : page);
		return curPage;
	}

	public List<Information> getList() {
		return list;
	}

	public void setList(List<Information> list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
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

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public void setFristPage(boolean isFristPage) {
		this.isFristPage = isFristPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
}
