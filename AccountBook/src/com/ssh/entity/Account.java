package com.ssh.entity;

import org.apache.struts2.json.annotations.JSON;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Users users;
	private String aname;
	private Double rest;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(Users users, String aname, Double rest) {
		this.users = users;
		this.aname = aname;
		this.rest = rest;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}
	
	@JSON(serialize=false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Double getRest() {
		return this.rest;
	}

	public void setRest(Double rest) {
		this.rest = rest;
	}

}