package com.expense.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.tracker.exception.BadRequestAlertException;
import com.expense.tracker.model.ExpenseCategory;
import com.expense.tracker.repository.ExpenseCategoryRepository;
import com.expense.tracker.repository.UserRepository;

@Service
public class ExpenseCategoryService {
	
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public ExpenseCategory save(ExpenseCategory expenseCategory) {
		validateExpenseCategoryInfo(expenseCategory);
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
	
	public void validateExpenseCategoryInfo(ExpenseCategory expenseCategory) {
		if(expenseCategory.getUserId() == null) {
			throw new BadRequestAlertException("User ID is mandatory");
		}
		if(!userRepository.findById(expenseCategory.getUserId()).isPresent()) {
			throw new BadRequestAlertException("Invalid User");
		}
	}
	
}
