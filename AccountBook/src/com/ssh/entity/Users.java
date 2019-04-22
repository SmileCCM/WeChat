package com.ssh.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String openid;
	private String nickname;
	private Integer gender;
	private String province;
	private Set accounts = new HashSet(0);
	private Set billses = new HashSet(0);
	private Set userclasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String openid) {
		this.openid = openid;
	}

	/** full constructor */
	public Users(String openid, String nickname, Integer gender, String province, Set accounts, Set billses,
			Set userclasses) {
		this.openid = openid;
		this.nickname = nickname;
		this.gender = gender;
		this.province = province;
		this.accounts = accounts;
		this.billses = billses;
		this.userclasses = userclasses;
	}

	// Property accessors

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Set getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set accounts) {
		this.accounts = accounts;
	}

	public Set getBillses() {
		return this.billses;
	}

	public void setBillses(Set billses) {
		this.billses = billses;
	}

	public Set getUserclasses() {
		return this.userclasses;
	}

	public void setUserclasses(Set userclasses) {
		this.userclasses = userclasses;
	}

}