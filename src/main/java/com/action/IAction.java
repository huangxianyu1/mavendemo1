package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.bean.Login;

public interface IAction {
	//���
	public String add(HttpServletRequest request, HttpServletResponse response, Employee em);
	//ɾ��
	public String delById(HttpServletRequest request, HttpServletResponse response);
	//�޸�
	public String update(HttpServletRequest request, HttpServletResponse response, Employee em);
	//���ҵ���-����
	public String findById(HttpServletRequest request, HttpServletResponse response);
	//�鵽lo����
	public String findByLname(HttpServletRequest request, HttpServletResponse response);
	//�޸ĵ�½����
	public String updateLpassword(HttpServletRequest request, HttpServletResponse response, Login lo);
	//����������֤
	public String forgetCheck(HttpServletRequest request, HttpServletResponse response);
	//���������޸�
	public String reset(HttpServletRequest request, HttpServletResponse response, Login lo);
	//��½�ж�
	public String loginn(HttpServletRequest request, HttpServletResponse response);
	//�鿴
	public String findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows);
	//������Ϣ
	public String pesonalInfoCheck(HttpServletRequest request, HttpServletResponse response);
	//����job.department
	public String dofind(HttpServletRequest request, HttpServletResponse response);
	//����job.department
	public String findByEid(HttpServletRequest request, HttpServletResponse response, Employee em);
}
