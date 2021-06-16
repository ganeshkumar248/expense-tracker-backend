package com.expense.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.tracker.model.ExpenseCategory;
import com.expense.tracker.repository.ExpenseCategoryRepository;

@Service
public class ExpenseCategoryService {
	
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	public ExpenseCategory save(ExpenseCategory expenseCategory) {
		return expenseCategoryRepository.save(expenseCategory);
	}
	
	public List<ExpenseCategory> getAll() {
		return expenseCategoryRepository.findAll();
	}
	
	public ExpenseCategory getOne(Long id) {
		return expenseCategoryRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		ExpenseCategory expenseCategory = getOne(id);
		expenseCategoryRepository.delete(expenseCategory);
	}

}
