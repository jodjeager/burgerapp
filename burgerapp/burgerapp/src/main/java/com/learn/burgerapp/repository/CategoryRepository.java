package com.learn.burgerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.burgerapp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	

}
