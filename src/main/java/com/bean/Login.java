package com.bean;

import java.io.Serializable;

public class Login implements Serializable {
	private String lid;
	private String lname;
	private String lpassword;
	private String lrootlevel;
	private String lquestion;
	private String lanswer;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String lid, String lname, String lpassword, String lrootlevel, String lquestion, String lanswer) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.lpassword = lpassword;
		this.lrootlevel = lrootlevel;
		this.lquestion = lquestion;
		this.lanswer = lanswer;
	}
	
	
	public Login(String lname, String lpassword, String lquestion, String lanswer) {
		super();
		this.lname = lname;
		this.lpassword = lpassword;
		this.lquestion = lquestion;
		this.lanswer = lanswer;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLpassword() {
		return lpassword;
	}
	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}
	public String getLrootlevel() {
		return lrootlevel;
	}
	public void setLrootlevel(String lrootlevel) {
		this.lrootlevel = lrootlevel;
	}
	public String getLquestion() {
		return lquestion;
	}
	public void setLquestion(String lquestion) {
		this.lquestion = lquestion;
	}
	public String getLanswer() {
		return lanswer;
	}
	public void setLanswer(String lanswer) {
		this.lanswer = lanswer;
	}
	
	
}
