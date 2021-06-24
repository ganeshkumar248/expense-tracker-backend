package com.expense.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.model.ExpenseCategory;
import com.expense.tracker.repository.ExpenseCategoryRepository;
import com.expense.tracker.service.ExpenseCategoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ExpenseCategoryController {
	
	@Autowired
	private ExpenseCategoryService expensecategoryService;
	
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	@PostMapping("/expense-categories")
	public ResponseEntity<ExpenseCategory> create(@RequestBody ExpenseCategory expenseCategory) {
		ExpenseCategory newExpenseCategory = expensecategoryService.save(expenseCategory);
		return new ResponseEntity<>(newExpenseCategory, HttpStatus.CREATED);
	}
	
//	@GetMapping("/expense-categories")
//	public ResponseEntity<List<ExpenseCategory>> getAll() {
//		List<ExpenseCategory> categoriesList = expensecategoryService.getAll();
//		return new ResponseEntity<List<ExpenseCategory>>(categoriesList, HttpStatus.OK);
//	}
	
	@GetMapping("/expense-categories")
	public ResponseEntity<List<ExpenseCategory>> getCategoriesByUserId(@RequestParam Long userId) {
		List<ExpenseCategory> allCategories = expenseCategoryRepository.findByUserId(userId);
		return new ResponseEntity<List<ExpenseCategory>>(allCategories, HttpStatus.OK);
	}
	
	@GetMapping("/expense-categories/{id}")
	public ResponseEntity<ExpenseCategory> getOne(@PathVariable("id") Long id) {
		ExpenseCategory expenseCategory = expensecategoryService.getOne(id);
		return new ResponseEntity<ExpenseCategory>(expenseCategory, HttpStatus.OK);
	}
	
	@PutMapping("/expense-categories")
	public ResponseEntity<ExpenseCategory> update(@RequestBody ExpenseCategory expenseCategory) {
		ExpenseCategory updateExpenseCategory = new ExpenseCategory(expenseCategory);
		ExpenseCategory newExpenseCategory = expensecategoryService.save(updateExpenseCategory);
		return new ResponseEntity<ExpenseCategory>(newExpenseCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/expense-categories/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		expensecategoryService.delete(id);
		return new ResponseEntity<String>("Category deleted successfully", HttpStatus.OK);
	}
	
}











