package com.learn.burgerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.burgerapp.dto.CategoryDTO;
import com.learn.burgerapp.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping
	public CategoryDTO create(@RequestBody CategoryDTO dto) {
		return service.create(dto);
	}
	
	
	
	@PutMapping("/{id}")
	public CategoryDTO update(@PathVariable long id, @RequestBody CategoryDTO dto) {
		return service.update(id, dto);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		 service.delete(id);
	}
	
	@GetMapping("/{id}")
	public CategoryDTO getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@GetMapping
	public List<CategoryDTO> getAll(){
		return service.getAll();
	}
	
	
}
