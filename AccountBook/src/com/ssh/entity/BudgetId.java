package com.ssh.entity;

/**
 * BudgetId entity. @author MyEclipse Persistence Tools
 */

public class BudgetId implements java.io.Serializable {

	// Fields

	private String bdate;
	private String openid;

	// Constructors

	/** default constructor */
	public BudgetId() {
	}

	/** full constructor */
	public BudgetId(String bdate, String openid) {
		this.bdate = bdate;
		this.openid = openid;
	}

	// Property accessors

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BudgetId))
			return false;
		BudgetId castOther = (BudgetId) other;

		return ((this.getBdate() == castOther.getBdate()) || (this.getBdate() != null && castOther.getBdate() != null
				&& this.getBdate().equals(castOther.getBdate())))
				&& ((this.getOpenid() == castOther.getOpenid()) || (this.getOpenid() != null
						&& castOther.getOpenid() != null && this.getOpenid().equals(castOther.getOpenid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBdate() == null ? 0 : this.getBdate().hashCode());
		result = 37 * result + (getOpenid() == null ? 0 : this.getOpenid().hashCode());
		return result;
	}

}