package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bean.*;

@Service("EmployeeMapper")
public interface IEmployeeMapper {
	public int addToEmployee(Employee em);// 人员添加
	public int addToLogin(Login lo);
	public int delByIdFromEm(String eid);// 开除
	public int delByIdFromLo(String lid);// 开除
	public int update(Employee em);// 调整
	public Employee findById(String eid);// 寻找单个
	public Login findByLname(String lname);// 通过登录找到此人
	public Employee findByLid(String lid);// 通过findByLname找到lid 找到Employee数据
	public List<Employee> findAll();// 查找全部
	public List<Login> fmlg();// 查找注册
	public int reset(Login lo);
	public int updateLpassword(Login lo);
	public List<Employee> findPageAll(PageBean pb);
	public int findMaxRows();
	public List<Dpartment> dodep();
	public List<Job> dojob();
	public Employee findByEname(String ename);
	public Employee findByEid(String eid);
	public Login findByElid(String elid);
}
