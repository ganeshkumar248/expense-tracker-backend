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

import com.expense.tracker.model.Expense;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.service.ExpenseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
//	@GetMapping("/expenses")
//	public ResponseEntity<List<Expense>> get(){
//		List<Expense> expenses = expenseService.findAll();
//		return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
//	}
	
	@GetMapping("/expenses/{id}")
	public ResponseEntity<Expense> getOne(@PathVariable("id") Long id){
		Expense expense = expenseService.findById(id);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
	@GetMapping("/expenses")
	public ResponseEntity<List<Expense>> getBasedOnUser(@RequestParam Long userId) {
		List<Expense> listOfExpensesByCurrentUser = expenseRepository.findByUserId(userId);
		return new ResponseEntity<List<Expense>>(listOfExpensesByCurrentUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		expenseService.delete(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	@PostMapping("/expenses")
	public ResponseEntity<Expense> save(@RequestBody Expense expense){
		Expense saveExpense = expenseService.save(expense);
		return new ResponseEntity<Expense>(saveExpense, HttpStatus.CREATED);
	}
	
	@PutMapping("/expenses")
	public ResponseEntity<Expense> update(@RequestBody Expense expense){
		Expense newExpense = new Expense(expense);
		Expense updatedExpense = expenseService.save(newExpense);
		return new ResponseEntity<Expense>(updatedExpense, HttpStatus.OK);
	}
}









