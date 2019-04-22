package com.ssh.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.entity.Budget;
import com.ssh.entity.BudgetId;
import com.ssh.service.BudgetService;

public class BudgetAction extends ActionSupport implements RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String openid;
	private String date;
	private Double amount;
	private BudgetService service = new BudgetService();
	private Map<String, Object> map = new HashMap<String, Object>();
	private String result;

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setService(BudgetService service) {
		this.service = service;
	}

	public BudgetService getService() {
		return service;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public String find() {
		BudgetId id = new BudgetId();
		id.setOpenid(openid);
		id.setBdate(date);
		Budget budget = new Budget();
		budget = service.findbudget(id);
		map.put("budget", budget);
		return "success";
	}

	public String update() {
		if (openid != null && date != null) {
			BudgetId id = new BudgetId();
			id.setOpenid(openid);
			id.setBdate(date);
			Budget budget = new Budget();
			budget.setId(id);
			budget.setAmount(amount);
			service.updatebud(budget);
			setResult("success");
		} else {
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
