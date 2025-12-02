package com.learn.burgerapp.service;

import java.util.List;

import com.learn.burgerapp.dto.CategoryDTO;

public interface CategoryService {
	
	CategoryDTO create(CategoryDTO dto);
	CategoryDTO update(long id, CategoryDTO dto);
	void delete(Long id);
	CategoryDTO getById(Long id);
	List<CategoryDTO>getAll();

}
