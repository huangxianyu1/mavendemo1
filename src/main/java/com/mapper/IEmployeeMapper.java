package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bean.*;

@Service("EmployeeMapper")
public interface IEmployeeMapper {
	public int addToEmployee(Employee em);// ��Ա���
	public int addToLogin(Login lo);
	public int delByIdFromEm(String eid);// ����
	public int delByIdFromLo(String lid);// ����
	public int update(Employee em);// ����
	public Employee findById(String eid);// Ѱ�ҵ���
	public Login findByLname(String lname);// ͨ����¼�ҵ�����
	public Employee findByLid(String lid);// ͨ��findByLname�ҵ�lid �ҵ�Employee����
	public List<Employee> findAll();// ����ȫ��
	public List<Login> fmlg();// ����ע��
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
