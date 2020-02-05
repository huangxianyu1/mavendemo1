package com.bean;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

public class Employee implements Serializable {// 12
	private String eid;
	private String ename;
	private String english;
	private String esex;
	private String etel;
	private String epartmentid;
	private String ejobid;
	private String eloginname;
	private String esalary;
	private String egoindate;
	private String fname = "default.jpg";
	private String lrootlevel;

	private String pshort;
	private String pname;
	private String jname;
	
	// Spring的文件上传
	private MultipartFile pic;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(String eid, String ename, String english, String esex, String etel, String epartmentid,
			String ejobid, String eloginname, String esalary, String egoindate, String fname, String pname,
			String jname, MultipartFile pic) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.english = english;
		this.esex = esex;
		this.etel = etel;
		this.epartmentid = epartmentid;
		this.ejobid = ejobid;
		this.eloginname = eloginname;
		this.esalary = esalary;
		this.egoindate = egoindate;
		this.fname = fname;
		this.pname = pname;
		this.jname = jname;
		this.pic = pic;
	}



	public Employee(String eid, String ename, String english, String esex, String etel, String epartmentid, String ejobid,
			String eloginname, String esalary, String egoindate, String fname, MultipartFile pic) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.english = english;
		this.esex = esex;
		this.etel = etel;
		this.epartmentid = epartmentid;
		this.ejobid = ejobid;
		this.eloginname = eloginname;
		this.esalary = esalary;
		this.egoindate = egoindate;
		this.fname = fname;
		this.pic = pic;
	}

	public Employee(String ename, String english, String esex, String etel, String epartmentid, String ejobid,
			String eloginname, String esalary, String egoindate, String fname, MultipartFile pic) {
		super();
		this.ename = ename;
		this.english = english;
		this.esex = esex;
		this.etel = etel;
		this.epartmentid = epartmentid;
		this.ejobid = ejobid;
		this.eloginname = eloginname;
		this.esalary = esalary;
		this.egoindate = egoindate;
		this.fname = fname;
		this.pic = pic;
	}

	
	public String getPshort() {
		return pshort;
	}

	public void setPshort(String pshort) {
		this.pshort = pshort;
	}

	public String getEsex() {
		return esex;
	}

	public void setEsex(String esex) {
		this.esex = esex;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEtel() {
		return etel;
	}

	public void setEtel(String etel) {
		this.etel = etel;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public String getEloginname() {
		return eloginname;
	}

	public void setEloginname(String eloginname) {
		this.eloginname = eloginname;
	}

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
	}

	public String getEgoindate() {
		return egoindate;
	}

	public void setEgoindate(String egoindate) {
		this.egoindate = egoindate;
	}

	public String getLrootlevel() {
		return lrootlevel;
	}

	public void setLrootlevel(String lrootlevel) {
		this.lrootlevel = lrootlevel;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}

	public String getEpartmentid() {
		return epartmentid;
	}

	public void setEpartmentid(String epartmentid) {
		this.epartmentid = epartmentid;
	}

	public String getEjobid() {
		return ejobid;
	}

	public void setEjobid(String ejobid) {
		this.ejobid = ejobid;
	}

}
