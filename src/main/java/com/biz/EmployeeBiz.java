package com.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.*;
import com.mapper.IEmployeeMapper;

@Service("EmployeeBiz")
@Transactional
public class EmployeeBiz implements IEmployeeBiz {
@Resource(name="EmployeeMapper")
	// 通过注入给emMapper赋值
	private IEmployeeMapper employeeDao;
	
	public IEmployeeMapper getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeMapper employeeDao) {
		this.employeeDao = employeeDao;
		System.out.println("************"+this.employeeDao+"*******");
	}

	public EmployeeBiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean addToEmployee(Employee em) {
		boolean flag = false;
		if (em != null) {
			int rows = employeeDao.addToEmployee(em);
			if (rows > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean addToLogin(Login lo) {
		boolean flag = false;
		if (lo != null) {
			int rows = employeeDao.addToLogin(lo);
			if (rows > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean delByIdFromEm(String eid) {
		boolean flag = false;
		int rows = employeeDao.delByIdFromEm(eid);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delByIdFromLo(String lid) {
		boolean flag = false;
		int rows = employeeDao.delByIdFromLo(lid);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean update(Employee em) {
		boolean flag = false;
		if (em != null) {
			int rows = employeeDao.update(em);
			if (rows > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean reset(Login lo) {
		boolean flag = false;
		if (lo != null) {
			int rows = employeeDao.reset(lo);
			if (rows > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean updateLpassword(Login lo) {
		boolean flag = false;
		if (lo != null) {
			int rows = employeeDao.updateLpassword(lo);
			if (rows > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public Employee findById(String eid) {
		return employeeDao.findById(eid);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public List<Login> fmlg() {
		return employeeDao.fmlg();
	}

	@Override
	public Login findByLname(String lname) {
		return employeeDao.findByLname(lname);
	}

	@Override
	public Employee findByLid(String lid) {
		return employeeDao.findByLid(lid);
	}

	@Override
	public List<Employee> findPageAll(Integer page, Integer rows) {
		page = (page - 1) * rows;
		return employeeDao.findPageAll(new PageBean(page,rows));
	}

	@Override
	public int findMaxRows() {
		return employeeDao.findMaxRows();
	}

	@Override
	public List<Job> dojob() {
		return employeeDao.dojob();
	}

	@Override
	public List<Dpartment> dodep() {
		return employeeDao.dodep();
	}

	@Override
	public Employee findByEname(String ename) {
		return employeeDao.findByEname(ename);
	}

	@Override
	public Employee findByEid(String eid) {
		return employeeDao.findByEid(eid);
	}

	@Override
	public Login findByElid(String elid) {
		return employeeDao.findByElid(elid);
	}

}
