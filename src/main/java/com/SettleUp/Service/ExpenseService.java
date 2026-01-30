package com.SettleUp.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SettleUp.Entity.Category;
import com.SettleUp.Entity.Expense;
import com.SettleUp.Entity.Group;
import com.SettleUp.Entity.Users;
import com.SettleUp.Repository.CategoryRepository;
import com.SettleUp.Repository.ExpenseRepository;
import com.SettleUp.Repository.GroupRepository;
import com.SettleUp.Repository.UserRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository,
                          GroupRepository groupRepository,
                          CategoryRepository categoryRepository){
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.categoryRepository = categoryRepository;
    }

    public Expense createExpense(Expense expense, Long paidById, Long groupId, Long categoryId){
        Users paidBy = userRepository.findById(paidById)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        expense.setPaidBy(paidBy);
        expense.setGroup(group);
        expense.setCategory(category);

        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByGroup(Long groupId){
        return expenseRepository.findByGroupId(groupId);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
}
