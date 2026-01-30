package com.SettleUp.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SettleUp.Entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByGroupId(Long groupId);
}

