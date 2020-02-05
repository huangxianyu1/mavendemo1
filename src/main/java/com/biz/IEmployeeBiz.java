package com.biz;

import java.util.List;

import com.bean.*;

public interface IEmployeeBiz {
public boolean addToEmployee(Employee em);
public boolean addToLogin(Login lo);
public boolean delByIdFromEm(String eid);
public boolean delByIdFromLo(String lid);
public boolean update(Employee em);
public Employee findById(String eid);
public Login findByLname(String lname);
public Employee findByLid(String lid);
public List<Employee> findAll();
public List<Login> fmlg();
public boolean reset(Login lo);
public boolean updateLpassword(Login lo);

public List<Employee> findPageAll(Integer page, Integer rows);
public int findMaxRows();

public List<Job> dojob();
public List<Dpartment> dodep();

public Employee findByEname(String ename);
public Employee findByEid(String eid);
public Login findByElid(String elid);
}
