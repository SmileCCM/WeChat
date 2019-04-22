package com.ssh.entity;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * Bills entity. @author MyEclipse Persistence Tools
 */

public class Bills implements java.io.Serializable {

	// Fields

	private Integer bid;
	private Users users;
	private String lx;
	private Date billdate;
	private String acct;
	private String class_;
	private Double money;
	private String remark;

	// Constructors

	/** default constructor */
	public Bills() {
	}

	/** full constructor */
	public Bills(Users users, String lx, Date billdate, String acct, String class_, Double money, String remark) {
		this.users = users;
		this.lx = lx;
		this.billdate = billdate;
		this.acct = acct;
		this.class_ = class_;
		this.money = money;
		this.remark = remark;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}
	@JSON(serialize=false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getLx() {
		return this.lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public Date getBilldate() {
		return this.billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public String getAcct() {
		return this.acct;
	}

	public void setAcct(String acct) {
		this.acct = acct;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}