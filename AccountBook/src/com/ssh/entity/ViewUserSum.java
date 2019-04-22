package com.ssh.entity;

/**
 * ViewUserSum entity. @author MyEclipse Persistence Tools
 */

public class ViewUserSum implements java.io.Serializable {

	// Fields

	private Integer bid;
	private String openid;
	private String date;
	private Double zc;
	private Double sr;

	// Constructors

	/** default constructor */
	public ViewUserSum() {
	}

	/** minimal constructor */
	public ViewUserSum(Integer bid) {
		this.bid = bid;
	}

	/** full constructor */
	public ViewUserSum(Integer bid, String openid, String date, Double zc, Double sr) {
		this.bid = bid;
		this.openid = openid;
		this.date = date;
		this.zc = zc;
		this.sr = sr;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getZc() {
		return this.zc;
	}

	public void setZc(Double zc) {
		this.zc = zc;
	}

	public Double getSr() {
		return this.sr;
	}

	public void setSr(Double sr) {
		this.sr = sr;
	}

}