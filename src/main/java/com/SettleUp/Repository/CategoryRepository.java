package com.SettleUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SettleUp.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
