package com.expense.tracker.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="tbl_expense")
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "expense_name")
	private String expenseName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "category")
	private String category;
	
	@CreationTimestamp
	@Column(name ="created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@Column(name = "actual_date")
	private Instant Date;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "user_id")
	private Long userId;
	
	public Expense() {
		
	}
	
	public Expense(Expense expense) {
		this.id = expense.getId();
		this.expenseName = expense.getExpenseName();
		this.description = expense.getDescription();
		this.category = expense.getCategory();
		this.amount = expense.getAmount();
		this.Date = expense.getDate();
		this.userId = expense.getUserId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Instant getDate() {
		return Date;
	}

	public void setDate(Instant date) {
		this.Date = date;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUser(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseName=" + expenseName + ", description=" + description + ", amount="
				+ amount + ", category=" + category + ", createdAt=" + createdAt + ", Date=" + Date + ", updatedAt="
				+ updatedAt + ", userId=" + userId + "]";
	}
}
