package com.esure.utils.page;

import java.util.List;

/**
 * 分页逻辑类
 * @description Pagination
 * @author ligy
 * @date 2015年11月18日 下午5:50:09
 *
 * @param <T>
 */
public class Pagination<T> {
	
	public Pagination() {
		super();
	}

	/**
	 * 分页的构造函数
	 * @param pageNo
	 * @param pageSize
	 * @param count
	 */
	public Pagination(int pageNo, int pageSize, int count) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.count = count;
	}

	/**
	 * 页号
	 */
	private int pageNo;
	
	/**
	 * 页长
	 */
	private int pageSize;
	
	/**
	 * 数据
	 */
	private List<T> list;

	/**
	 * 总数
	 */
	private int count;

	/**
	 * 初始化页号
	 * @description cpn
	 * @author ligy
	 * @date 2015年11月18日 下午5:54:39
	 * @param pageNo
	 * @return
	 */
	public static Integer cpn(Integer pageNo) {
		if(pageNo == null) {
			return 1;
		}
		if(pageNo != null && pageNo < 1) {
			return 1;
		}
		return pageNo;
	}
	
	/**
	 * 获取页号
	 * @description getPageNo
	 * @author ligy
	 * @date 2015年11月18日 下午6:02:06
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置页号
	 * @description setPageNo
	 * @author ligy
	 * @date 2015年11月18日 下午6:02:21
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 获取页长
	 * @description getPageSize
	 * @author ligy
	 * @date 2015年11月18日 下午6:02:37
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置页长
	 * @description setPageSize
	 * @author ligy
	 * @date 2015年11月18日 下午6:03:03
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取数据
	 * @description getList
	 * @author ligy
	 * @date 2015年11月18日 下午6:03:24
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置数据
	 * @description setList
	 * @author ligy
	 * @date 2015年11月18日 下午6:03:40
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 获取总数
	 * @description getCount
	 * @author ligy
	 * @date 2015年11月18日 下午6:03:55
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 设置总数
	 * @description setCount
	 * @author ligy
	 * @date 2015年11月18日 下午6:04:12
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
