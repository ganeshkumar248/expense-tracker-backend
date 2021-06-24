package com.expense.tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.tracker.model.Expense;
import com.expense.tracker.model.User;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	Optional<User> findByUserId(User user);
	List<Expense> findByUserId(Long userId);
}
