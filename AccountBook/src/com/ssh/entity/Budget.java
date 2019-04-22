package com.ssh.entity;

/**
 * Budget entity. @author MyEclipse Persistence Tools
 */

public class Budget implements java.io.Serializable {

	// Fields

	private BudgetId id;
	private Double amount;

	// Constructors

	/** default constructor */
	public Budget() {
	}

	/** minimal constructor */
	public Budget(BudgetId id) {
		this.id = id;
	}

	/** full constructor */
	public Budget(BudgetId id, Double amount) {
		this.id = id;
		this.amount = amount;
	}

	// Property accessors

	public BudgetId getId() {
		return this.id;
	}

	public void setId(BudgetId id) {
		this.id = id;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}