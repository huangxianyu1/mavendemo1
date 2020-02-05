package com.bean;

import java.io.Serializable;

public class Job implements Serializable {
private String jid;
private String jname;
public Job(String jid, String jname) {
	super();
	this.jid = jid;
	this.jname = jname;
}
public Job() {
	super();
	// TODO Auto-generated constructor stub
}
public String getJid() {
	return jid;
}
public void setJid(String jid) {
	this.jid = jid;
}
public String getJname() {
	return jname;
}
public void setJname(String jname) {
	this.jname = jname;
}

}
