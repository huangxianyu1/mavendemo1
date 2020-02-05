package com.bean;

import java.io.Serializable;

public class Dpartment implements Serializable {
private String pid;
private String pname;
private String pshort;
public Dpartment(String pid, String pname, String pshort) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.pshort = pshort;
}
public Dpartment() {
	super();
	// TODO Auto-generated constructor stub
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPshort() {
	return pshort;
}
public void setPshort(String pshort) {
	this.pshort = pshort;
}


}
