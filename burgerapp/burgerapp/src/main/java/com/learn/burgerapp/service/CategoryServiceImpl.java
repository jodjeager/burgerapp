package com.learn.burgerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.burgerapp.dto.CategoryDTO;
import com.learn.burgerapp.entities.Category;
import com.learn.burgerapp.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	private CategoryDTO toDTO(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		return dto;
	}
	
	private Category toEntity(CategoryDTO dto)
	{
		Category c =new Category();
		c.setId(dto.getId());
		c.setName(dto.getName());
		return c;
		
	

	
	}

	@Override
	public CategoryDTO create(CategoryDTO dto) {
		
		return toDTO(categoryRepo.save(toEntity(dto)));
	}

	@Override
	public CategoryDTO update(long id, CategoryDTO dto) {
		Category existing = categoryRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Category not found"));
		existing.setName(dto.getName());
		return toDTO(categoryRepo.save(existing));
	}

	@Override
	public void delete(Long id) {
		categoryRepo.deleteById(id);
		
	}

	@Override
	public CategoryDTO getById(Long id) {
		
		return categoryRepo.findById(id).map(this::toDTO)
				.orElseThrow(()-> new RuntimeException("Category not found"));
				
	}

	@Override
	public List<CategoryDTO> getAll() {
		
		return categoryRepo.findAll().stream().map(this::toDTO).toList();
	}

}
