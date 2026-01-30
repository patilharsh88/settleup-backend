package com.SettleUp.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SettleUp.Entity.Expense;
import com.SettleUp.Service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping("/{paidById}/{groupId}/{categoryId}")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense,
                                                 @PathVariable Long paidById,
                                                 @PathVariable Long groupId,
                                                 @PathVariable Long categoryId){
        return ResponseEntity.ok(expenseService.createExpense(expense, paidById, groupId, categoryId));
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<Expense>> getExpensesByGroup(@PathVariable Long groupId){
        return ResponseEntity.ok(expenseService.getExpensesByGroup(groupId));
    }
}
