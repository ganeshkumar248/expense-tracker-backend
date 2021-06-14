package com.expense.tracker.service;

import java.util.List;

import com.expense.tracker.model.Expense;

public interface ExpenseService {
	
	List<Expense> findAll();
	
	Expense findById(Long id);
	
	void delete(Long id);
	
	Expense save(Expense expense);

}
