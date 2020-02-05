package com.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Dpartment;
import com.bean.Employee;
import com.bean.Job;
import com.bean.Login;
import com.bean.PageBean;
import com.biz.IEmployeeBiz;
import com.util.AjAxUtils;

@Controller
public class EmployeeAction implements IAction {
	@Resource(name = "EmployeeBiz")
	private IEmployeeBiz ibiz;

	public IEmployeeBiz getIbiz() {
		return ibiz;
	}

	public void setIbiz(IEmployeeBiz ibiz) {
		this.ibiz = ibiz;
	}

	@RequestMapping(value = "add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, Employee em) {
		String realpath = request.getRealPath("/");
		/********** 文件上传 ************/
		// 获取上传照片对象
		MultipartFile multipartFile = em.getPic();
		if (multipartFile != null && !multipartFile.isEmpty()) {
			// 获取上传文件名称
			String fname = multipartFile.getOriginalFilename();
			// 更名
			if (fname.lastIndexOf(".") != -1) {
				// 获取后缀
				String ext = fname.substring(fname.lastIndexOf("."));
				// 判断后缀格式
				if (ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".PNG") || ext.equalsIgnoreCase(".jpeg")) {
					// 改名
					String newfname = new Date().getTime() + ext;
					// 创建文件对象，指定上传文件的路径
					File dostFile = new File(realpath + "/uppic/" + newfname);
					// 上传
					try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostFile);
						em.setFname(newfname);
						System.out.println("add.do.newfname" + newfname);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		/********** 文件上传end ************/
		boolean flag = ibiz.addToEmployee(em);
		if (flag) {
			return "addToLogin.do";
		} else {
			return "redirect:errorAdd.jsp";
		}

	}

	@RequestMapping(value = "addToLogin.do")
	public String findByEid(HttpServletRequest request, HttpServletResponse response, Employee em) {
		Employee emp=ibiz.findByEname(em.getEname());
		String eid = emp.getEpartmentid();
		System.out.println(eid);
		List<Dpartment> listd = ibiz.dodep();
		String shortname = listd.get(Integer.parseInt(eid)).getPshort();
		Login lo = new Login();
		// 添加到login
		String lname1 = em.getEnglish() + (int) (Math.random() * 100) + shortname;
		List<Login> listlo = ibiz.fmlg();
		boolean judge = true;
		while (judge) {
			for (Login li : listlo) {
				if (li.getLname().equals(lname1)) {
					lname1 = em.getEnglish() + (int) (Math.random() * 100) + em.getPname();
					judge = true;
				} else {
					judge = false;
				}
			}
		}
		lo.setLname(lname1);
		lo.setLpassword("000000");
		if (em.getEpartmentid().equals("1") || em.getEjobid().equals("7")) {
			lo.setLrootlevel("1");
		} else {
			lo.setLrootlevel("2");
		}
		lo.setLquestion("您的生日是什么时候？");
		lo.setLanswer("");
		boolean flag = ibiz.addToLogin(lo);
		if (flag) {
			return "redirect:findPageAll.do";
		} else {
			return "redirect:errorAdd.jsp";
		}

	}

	@RequestMapping(value = "delById.do")
	public String delById(HttpServletRequest request, HttpServletResponse response) {
		String eid = request.getParameter("eid");
		boolean flag = ibiz.delByIdFromEm(eid);
		if (flag) {
			flag = ibiz.delByIdFromLo(eid);
			if(flag){
				AjAxUtils.printString(response, ""+1);
			}else{
				AjAxUtils.printString(response, ""+0);
			}
			return null;
		} else {
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}

	@RequestMapping(value = "findById.do")
	public String findById(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String eid = request.getParameter("eid");
		Employee em = ibiz.findById(eid);
		session.setAttribute("em", em);
		return "redirect:update2.jsp";
	}

	@RequestMapping(value = "update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, Employee em) {
		// 获取原来的照片，在不修改照片的时候，展示原来的照片
		String oldfname = ibiz.findById(em.getEid()).getFname();

		String realpath = request.getRealPath("/");
		/********** 文件上传 ************/
		// 获取上传照片对象
		MultipartFile multipartFile = em.getPic();
		System.out.println("update.do.multipartFile" + multipartFile);
		if (multipartFile != null && !multipartFile.isEmpty()) {
			// 获取上传文件名称
			String fname = multipartFile.getOriginalFilename();
			// 更名
			if (fname.lastIndexOf(".") != -1) {
				// 获取后缀
				String ext = fname.substring(fname.lastIndexOf("."));
				// 判断后缀格式
				if (ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".PNG") || ext.equalsIgnoreCase(".jpeg")) {
					// 改名
					String newfname = new Date().getTime() + ext;
					// 创建文件对象，指定上传文件的路径
					File dostFile = new File(realpath + "/uppic/" + newfname);
					// 上传
					System.out.println("111111111111");
					try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostFile);
						System.out.println("文件上传成功");
						em.setFname(newfname);
						// 删除原来的照片，获取原来的文件对象
						File oldfile = new File(realpath + "/uppic/" + oldfname);
						if (oldfile.exists() && !oldfile.equals("default.jpg")) {
							oldfile.delete();// 删除原来的
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			// 没有文件上传
			em.setFname(oldfname);
		}
		/********** 文件上传end ************/
		boolean flag = ibiz.update(em);
		if (flag) {
			return "redirect:findPageAll.do";
		}

		return "redirect:errorUpdate.jsp";
	}

	@RequestMapping(value = "forgetCheck.do")
	public String forgetCheck(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String lname = request.getParameter("lname");
		String lquestion = request.getParameter("lquestion");
		String lanswer = request.getParameter("lanswer");
		Login lo = ibiz.findByLname(lname);
		session.setAttribute("lo", lo);
		if (lo.getLname().equals(lname) && lo.getLquestion().equals(lquestion) && lo.getLanswer().equals(lanswer)) {
			return "reset.jsp";
		} else {
			return "errorReset.jsp";
		}
	}

	@RequestMapping(value = "reset.do")
	public String reset(HttpServletRequest request, HttpServletResponse response, Login lo) {
		HttpSession session = request.getSession();
		String lname = request.getParameter("lname");
		String lpassword = request.getParameter("lpassword");
		String lquestion = request.getParameter("lquestion");
		String lanswer = request.getParameter("lanswer");
		System.out.println(lname+lpassword+lquestion+lanswer);
		boolean flag = ibiz.reset(lo);
		if(flag){
			AjAxUtils.printString(response, ""+1);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}

	@RequestMapping(value = "findByLname.do")
	public String findByLname(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Login lo = ibiz.findByLname(request.getParameter("lname"));
		session.setAttribute("lo", lo);
		return "ResetLoginPassword.jsp";
	}

	@RequestMapping(value = "updateLpassword.do")
	public String updateLpassword(HttpServletRequest request, HttpServletResponse response, Login lo) {
		HttpSession session = request.getSession();
		lo = (Login) session.getAttribute("lo");
		String lpassword1 = request.getParameter("lpassword1");// 原始密码
		String lpassword = request.getParameter("lpassword");// 第一次输入
		String lpassword2 = request.getParameter("lpassword2");// 第二次输入
		String oldpassword = lo.getLpassword();
		System.out.println("lpassword1"+lpassword1);
		System.out.println("lpassword"+lpassword);
		System.out.println("lpassword2"+lpassword2);
		if (oldpassword.equals(lpassword1)) {
			if (lpassword2.equals(lpassword)) {
				lo.setLpassword(lpassword);
				boolean flag = ibiz.updateLpassword(lo);
				if(flag){
					AjAxUtils.printString(response, ""+1);
				}else{
					AjAxUtils.printString(response, ""+0);
				}
				return null;
			} else {
				AjAxUtils.printString(response, ""+0);
			}
		} else {
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}

	@RequestMapping(value = "findPageAll.do")
	public String findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		HttpSession session = request.getSession();
		// 初始化下拉列表
		List<Job> listjob = ibiz.dojob();
		List<Dpartment> listdep = ibiz.dodep();
		session.setAttribute("listjob", listjob);
		session.setAttribute("listdep", listdep);
		PageBean pb = (PageBean) session.getAttribute("pb");
		pb = pb == null ? new PageBean() : pb;
		page = page == null || page < 1 ? pb.getPage() : page;
		rows = rows == null || rows < 1 ? pb.getRows() : rows;
		int maxRows = ibiz.findMaxRows();
		int maxPage = 1;
		if (rows > 5)
			rows = 5;
		if (maxRows != 0) {
			maxPage = maxRows % rows == 0 ? maxRows / rows : maxRows / rows + 1;
		}
		if (page > maxPage)
			page = maxPage;// 如果当前页面数超过最大页面数，设置为最大页面数
		// 获取当前页记录集合
		pb.setPage(page);
		pb.setRows(rows);
		List<Employee> lsst = ibiz.findPageAll(page, rows);
		// 检查分页数据封装pb对象
		pb.setMaxPage(maxPage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(lsst);
		session.setAttribute("pb", pb);
		return "show3.jsp";
	}

	@RequestMapping(value = "LnameCheck.do")
	public String LnameCheck(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<Employee> listem = ibiz.findAll();
		System.out.println(listem.get(1).getPname());
		List<Login> listlo = ibiz.fmlg();
		session.setAttribute("listem", listem);
		session.setAttribute("listlo", listlo);
		return "Lname.jsp";
	}

	@RequestMapping(value = "loginn.do")
	public String loginn(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<Login> listl = ibiz.fmlg();
		// 获取输入账号密码
		String lname1 = request.getParameter("lname");
		String lpassword1 = request.getParameter("lpassword");
		session.setAttribute("lname", lname1);
		// 获取数据库账户密码
		int count = 0;
		for (int i = 0; i < listl.size(); i++) {
			if (listl.get(i).getLpassword().equals(lpassword1) && listl.get(i).getLname().equals(lname1)
					&& listl.get(i).getLrootlevel().equals("1")) {
				count = 1;
				break;
			} else if (listl.get(i).getLpassword().equals(lpassword1) && listl.get(i).getLname().equals(lname1)
					&& listl.get(i).getLrootlevel().equals("2")) {
				count = 2;
				break;
			}
		}
		if (count == 1) {
			return "findPageAll.do";
		} else if (count == 2) {
			return "pesonalInfoCheck.do?lname=" + lname1;
		} else {
			return "errorLogin.jsp";
		}
	}

	@RequestMapping(value = "pesonalInfoCheck.do")
	public String pesonalInfoCheck(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String lname = (String) session.getAttribute("lname");
		System.out.println("lname:"+lname);
		Login lo=ibiz.findByLname(lname);
		session.setAttribute("lo", lo);
		String eids = lo.getLid();// 找到lid
		Employee em = ibiz.findByEid(eids);// 通过Lid找到employee中所有条目
		session.setAttribute("em", em);
		return "justView2.jsp";
	}

	@RequestMapping(value = "dofind.do")
	public String dofind(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 初始化班级下拉列表
		List<Job> listjob = ibiz.dojob();
		List<Dpartment> listdep = ibiz.dodep();
		session.setAttribute("listdep", listdep);
		session.setAttribute("listjob", listjob);
		return "add.jsp";
	}

}
