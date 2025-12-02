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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.burgerapp.dto.ProductDTO;
import com.learn.burgerapp.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	public ProductDTO create(@RequestBody ProductDTO dto) {
		return service.create(dto);
		
	}
	
	@PutMapping("/{id}")
	public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO dto) {
		return service.update(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ProductDTO getById(@PathVariable Long id ) {
		return service.getById(id);
	}
	
	@GetMapping
	public List<ProductDTO>getAll(){
		return service.getAll();
	}
	
	@GetMapping("/name/{name}")
	public List<ProductDTO> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping("/price/max/{price}")
	public List<ProductDTO>findByPriceLessThanEqual(@PathVariable double price){
		return service.findByPriceLessThanEqual(price);
	}
	
	@GetMapping("price/between")
	public List<ProductDTO>findByPriceBetween(@RequestParam double min,
		                                    	@RequestParam double max){
		return service.findByPriceBetween(min, max);
	}
	
	@GetMapping("/category/{categoryId}")
	public  List<ProductDTO>findByCategory(@PathVariable Long categoryId){
		return service.findByCategory(categoryId);
	}
	
	
	}
