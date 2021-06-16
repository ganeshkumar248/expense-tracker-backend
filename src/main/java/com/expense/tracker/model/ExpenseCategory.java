package com.expense.tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense_category")
public class ExpenseCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "description")
	private String description;
	
	public ExpenseCategory() {
		
	}
	
	public ExpenseCategory(ExpenseCategory expenseCategory) {
		this.id = expenseCategory.getId();
		this.categoryName = expenseCategory.getCategoryName();
		this.description = expenseCategory.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ExpenseCategory [id=" + id + ", categoryName=" + categoryName + ", description=" + description + "]";
	}
	
}
