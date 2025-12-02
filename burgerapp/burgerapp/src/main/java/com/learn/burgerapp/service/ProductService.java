package com.learn.burgerapp.service;

import java.util.List;

import com.learn.burgerapp.dto.ProductDTO;

public interface ProductService {

	ProductDTO create(ProductDTO dto);
	
	ProductDTO update(long id, ProductDTO dto);
	
	void delete(long id);
	
	ProductDTO getById(long id);
	List<ProductDTO>getAll();
	
	List<ProductDTO> findByName(String name);
	
	List<ProductDTO> findByPriceLessThanEqual(double price);
	
	List<ProductDTO> findByPriceBetween(double min, double max);
	
	List<ProductDTO> findByCategory(Long categoryId);
	
	
}
