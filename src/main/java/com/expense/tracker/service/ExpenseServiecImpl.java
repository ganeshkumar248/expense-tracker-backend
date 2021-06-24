package com.expense.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.tracker.exception.BadRequestAlertException;
import com.expense.tracker.model.Expense;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.repository.UserRepository;

@Service
public class ExpenseServiecImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}

	@Override
	public Expense findById(Long id) {
		if(expenseRepository.findById(id).isPresent()) {
			return expenseRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Expense expense = findById(id);
		expenseRepository.delete(expense);
	}

	@Override
	public Expense save(Expense expense) {
		validateExpenseInfo(expense);
		 Expense saveExpense = expenseRepository.save(expense);
		return saveExpense;
	}
	
	public void validateExpenseInfo(Expense expense) {
		if(expense.getUserId() == null) {
			throw new BadRequestAlertException("User ID is mandatory");
		}
		if(!userRepository.findById(expense.getUserId()).isPresent()) {
			throw new BadRequestAlertException("Invalid User");
		}
	}
}



















