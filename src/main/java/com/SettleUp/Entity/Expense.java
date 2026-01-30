package com.SettleUp.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal amount;

    private String note;

    private LocalDate expenseDate;

    @ManyToOne
    @JoinColumn(name = "paid_by")
    private Users paidBy;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Getters & Setters
    public String getTitle() { 
    	return title; 
    	}
    public void setTitle(String title) { 
    	this.title = title; 
    }

    public BigDecimal getAmount() { 
    	return amount; 
    	}
    public void setAmount(BigDecimal amount) { 
    	this.amount = amount;
    	}

    public String getNote() { 
    	return note;
    	}
    public void setNote(String note) { 
    	this.note = note; 
    	}

    public LocalDate getExpenseDate() { 
    	return expenseDate; 
    	}
    public void setExpenseDate(LocalDate expenseDate) { 
    	this.expenseDate = expenseDate; 
    	}

    public Users getPaidBy() {
    	return paidBy;
    	}
    public void setPaidBy(Users paidBy) {
    	this.paidBy = paidBy;
    	}

    public Group getGroup() {
    	return group;
    	}
    public void setGroup(Group group) {
    	this.group = group;
    	}

    public Category getCategory() {
    	return category; 
    	}
    public void setCategory(Category category) {
    	this.category = category; 
    	}
}
