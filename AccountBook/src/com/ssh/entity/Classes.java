package com.ssh.entity;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private String lx;

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(String cname, String lx) {
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