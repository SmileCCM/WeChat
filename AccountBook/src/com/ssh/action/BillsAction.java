package com.ssh.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.entity.Bills;
import com.ssh.entity.Users;
import com.ssh.entity.ViewUserSum;
import com.ssh.service.BillsService;

public class BillsAction extends ActionSupport implements RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bid;
	private String openid;
	private String lx;
	private Date billdate;
	private String acct;
	private String class_;
	private Double money;
	private String remark;
	private String result;
	private BillsService service = new BillsService();
	private Map<String, Object> map = new HashMap<String, Object>();
	private String bdate;
	
	private Double min;
	private Double max;
	private String classes;
	private String seek;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public String getAcct() {
		return acct;
	}

	public void setAcct(String acct) {
		this.acct = acct;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setService(BillsService service) {
		this.service = service;
	}

	public BillsService getService() {
		return service;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBdate() {
		return bdate;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getSeek() {
		return seek;
	}

	public void setSeek(String seek) {
		this.seek = seek;
	}

	public String addbill() {
		try {
			Users user = new Users();
			user.setOpenid(openid);
			Bills bill = new Bills();
			bill.setLx(lx);
			bill.setAcct(acct);
			bill.setBilldate(billdate);
			bill.setClass_(class_);
			bill.setMoney(money);
			bill.setRemark(remark);
			bill.setUsers(user);
			service.addbill(bill);
			setResult("success");
		} catch (Exception e) {
			// TODO: handle exception
			setResult("error");
		}
		return "success";
	}

	public String findbills() {
		try {
			ViewUserSum s = new ViewUserSum();
			s.setOpenid(openid);
			s.setDate(bdate);
			List<ViewUserSum> ss = new ArrayList<ViewUserSum>();
			ss = service.findsum(s);

			List<Bills> bs = new ArrayList<Bills>();
			bs = service.findbills(openid, bdate);
			map.put("sum", ss);
			map.put("billsofm", bs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

	public String findbyconditons() {
		try {
			if (min != null && max != null) {
				if (min > max) {
					Double temp = null;
					temp = min;
					min = max;
					max = temp;
				}
			}
			List<Bills> bs = new ArrayList<Bills>();
			bs = service.findbyconditions(min, max, classes, seek, openid);
			map.put("bills", bs);
		} catch (Exception e) {
			// TODO: handle exception
			setResult("error");
		}
		return "success";
	}

	public String updatebill() {
		try {
			if (bid != null) {
				Users user = new Users();
				user.setOpenid(openid);
				Bills bill = new Bills();
				bill.setBid(bid);
				bill.setLx(lx);
				bill.setAcct(acct);
				bill.setBilldate(billdate);
				bill.setClass_(class_);
				bill.setMoney(money);
				bill.setRemark(remark);
				bill.setUsers(user);
				service.updatebill(bill);
				setResult("success");
			} else {
				setResult("error");
			}
		} catch (Exception e) {
			// TODO: handle exception
			setResult("error");
		}
		return "success";
	}
    public String remove(){
    	try {
			if (bid != null) {
				Bills bill = new Bills();
				bill.setBid(bid);
				service.remove(bill);
				setResult("success");
			} else {
				setResult("error");
			}
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
