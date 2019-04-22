package com.ssh.entity;

import org.apache.struts2.json.annotations.JSON;

/**
 * Userclass entity. @author MyEclipse Persistence Tools
 */

public class Userclass implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Users users;
	private String cname;
	private String lx;

	// Constructors

	/** default constructor */
	public Userclass() {
	}

	/** full constructor */
	public Userclass(Users users, String cname, String lx) {
		this.users = users;
		this.cname = cname;
		this.lx = lx;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	@JSON(serialize=false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLx() {
		return this.lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

}