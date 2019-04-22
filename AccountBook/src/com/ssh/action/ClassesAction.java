package com.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.entity.Classes;
import com.ssh.entity.Userclass;
import com.ssh.entity.Users;
import com.ssh.service.ClassesService;

public class ClassesAction extends ActionSupport implements RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String openid;
	private String result;

	private Integer cid;
	private String cname;
	private String lx;

	private Map<String, Object> map = new HashMap<String, Object>();
	private ClassesService service = new ClassesService();

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return cname;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getLx() {
		return lx;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setService(ClassesService service) {
		this.service = service;
	}

	public ClassesService getService() {
		return service;
	}

	public String getclasses() {
		Users u = new Users();
		u.setOpenid(openid);
		List<Classes> cs = new ArrayList<Classes>();
		cs = service.findclasses();

		List<Userclass> us = new ArrayList<Userclass>();
		us = service.finduserc(u);
		map.put("cs", cs);
		map.put("ucs", us);
		return SUCCESS;
	}

	public String addc() {
		try {
			Users u = new Users();
		    u.setOpenid(openid);
		    Userclass uc=new Userclass();
		    uc.setCname(cname);
		    uc.setLx(lx);
		    uc.setUsers(u);
		    int i=service.addclass(uc);
		    if(i==1)
                setResult(SUCCESS);
		    else
		    	setResult("error");
		} catch (Exception e) {
			// TODO: handle exception
			setResult("error");
		}
		return SUCCESS;
	}

	public String update() {
		try {
			Users u = new Users();
		    u.setOpenid(openid);
		    Userclass uc=new Userclass();
		    uc.setCid(cid);
		    uc.setCname(cname);
		    uc.setLx(lx);
		    uc.setUsers(u);
		    service.update(uc);
		    setResult(SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			setResult("error");
		}
		return SUCCESS;
	}

	public String remove() {
		try {
		    Userclass uc=new Userclass();
		    uc.setCid(cid);;
		    service.delete(uc);
		    setResult(SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			setResult("error");
		}	
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO 自动生成的方法存根

	}

}
