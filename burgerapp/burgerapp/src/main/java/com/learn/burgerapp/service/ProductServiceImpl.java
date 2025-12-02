package com.learn.burgerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.burgerapp.dto.ProductDTO;
import com.learn.burgerapp.entities.Product;
import com.learn.burgerapp.repository.CategoryRepository;
import com.learn.burgerapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	private ProductDTO toDTO(Product p) {
		ProductDTO dto = new ProductDTO();
		dto.setId(p.getId());
		dto.setName(p.getName());
		dto.setDescription(p.getDescription());
		dto.setPrice(p.getPrice());
		dto.setCategoryId(p.getCategory().getId());
		dto.setCategoryName(p.getCategory().getName());
		return dto;
	}
	
	private Product toEntity(ProductDTO dto) {
		Product p = new Product();
		p.setId(dto.getId());
		p.setName(dto.getName());
		p.setDescription(dto.getDescription());
		p.setPrice(dto.getPrice());
		p.setCategory(categoryRepo.findById(dto.getCategoryId())
				.orElseThrow(()-> new RuntimeException("Category not Found")));
		return p;
	}
	

	@Override
	public ProductDTO create(ProductDTO dto) {
		return toDTO(repo.save(toEntity(dto)));
		
	}

	@Override
	public ProductDTO update(long id, ProductDTO dto) {
		Product existing = repo.findById(id)
				.orElseThrow(()->new RuntimeException("Product not found"));
		
		existing.setName(dto.getName());
		existing.setPrice(dto.getPrice());
		existing.setDescription(dto.getDescription());
		existing.setCategory(categoryRepo.findById(dto.getCategoryId())
				.orElseThrow(()->new RuntimeException("Category not found")));
		return toDTO(repo.save(existing));
	}
	
	

	@Override
	public void delete(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public ProductDTO getById(long id) {
		return toDTO(repo.findById(id).orElseThrow(()-> new RuntimeException("Product not found")));

	}

	@Override
	public List<ProductDTO> getAll() {
		
		return repo.findAll().stream().map(this::toDTO).toList();
	}

	@Override
	public List<ProductDTO> findByName(String name) {
		
		return repo.findByName(name).stream().map(this::toDTO).toList();
	}

	@Override
	public List<ProductDTO> findByPriceLessThanEqual(double price) {
		
		return repo.findByPriceLessThanEqual(price).stream().map(this::toDTO).toList();
	}

	@Override
	public List<ProductDTO> findByPriceBetween(double min, double max) {
		
		return repo.findByPriceBetween(min, max).stream().map(this::toDTO).toList();
	}

	@Override
	public List<ProductDTO> findByCategory(Long categoryId) {
		
		return repo.findByCategoryId(categoryId).stream().map(this::toDTO).toList();
	}

	
	
	
	
}
