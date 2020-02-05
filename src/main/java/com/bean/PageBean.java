package com.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {//分页实体类
private Integer page=1;//当前页
private Integer rows=5;//每页显示数
private Integer maxPage;//最大页数
private List<?> pagelist;//分页查询返回的
public PageBean(Integer page, Integer rows, Integer maxPage, List<?> pagelist) {
	super();
	this.page = page;
	this.rows = rows;
	this.maxPage = maxPage;
	this.pagelist = pagelist;
}
public PageBean(Integer page, Integer rows) {
	super();
	this.page = page;
	this.rows = rows;
}
public Integer getPage() {
	return page;
}
public void setPage(Integer page) {
	this.page = page;
}
public Integer getRows() {
	return rows;
}
public void setRows(Integer rows) {
	this.rows = rows;
}
public Integer getMaxPage() {
	return maxPage;
}
public void setMaxPage(Integer maxPage) {
	this.maxPage = maxPage;
}
public List<?> getPagelist() {
	return pagelist;
}
public void setPagelist(List<?> pagelist) {
	this.pagelist = pagelist;
}
public PageBean() {
	super();
	// TODO Auto-generated constructor stub
}




}
