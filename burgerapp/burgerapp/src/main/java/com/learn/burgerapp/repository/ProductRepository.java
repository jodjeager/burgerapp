package com.learn.burgerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.burgerapp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByName(String name);
	
	List<Product> findByPriceLessThanEqual(double price);
	
	List<Product> findByPriceBetween(double min, double max);
	
	List<Product> findByCategoryId(Long categoryId);
}
