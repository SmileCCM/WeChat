package com.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.entity.Account;
import com.ssh.entity.Users;
import com.ssh.service.UserAccountService;

public class AccountAction extends ActionSupport implements RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2978258438998007220L;
	private String openid;
	private Map<String, Object> map = new HashMap<String, Object>();
	private UserAccountService accountService = new UserAccountService();
	private Integer aid;
	private String aname;
	private Double rest;
	private String result;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	@JSON(serialize = false)
	public UserAccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Double getRest() {
		return rest;
	}

	public void setRest(Double rest) {
		this.rest = rest;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String togetAccount() {
		List<Account> accounts = new ArrayList<Account>();
		accounts = accountService.getAccounts(getOpenid());
		map.put("accounts", accounts);
		return "success";
	}

	public String addacount() {
		if (openid != null && aname != null) {
			Users user = new Users();
			user.setOpenid(openid);
			Account account = new Account();
			account.setAname(aname);
			account.setRest(rest);
			account.setUsers(user);
			int i;
			i = accountService.addaccount(account);
			if (i == 0) {
				setResult("error");
			} else {
				setResult("success");
			}
		} else {
			setResult("error");
		}
		return "success";
	}

	public String updateacc() {
		if (openid != null && aname != null & aid != null) {
			Users user = new Users();
			user.setOpenid(openid);
			Account account = new Account();
			account.setAid(aid);
			account.setAname(aname);
			account.setRest(rest);
			account.setUsers(user);
			accountService.updateacc(account);
			setResult("success");
		} else {
			setResult("error");
		}
		return "success";
	}

	public String deleteacc() {
		try {
			Account a = new Account();
			a.setAid(aid);
			accountService.deleteacc(a);
			setResult("success");
		} catch (Exception e) {
			// TODO: handle exception
			setResult("error");
		}
		return "success";
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
