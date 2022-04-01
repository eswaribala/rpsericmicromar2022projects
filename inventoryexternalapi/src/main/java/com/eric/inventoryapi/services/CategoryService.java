package com.eric.inventoryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.inventoryapi.models.Category;
import com.eric.inventoryapi.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	//insert
	
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	//select all
	public List<Category> getAllCategories(){
		return this.categoryRepository.findAll();
	}
	
	//select by id
	
	public Category getCategoryById(long categoryId) {
		return this.categoryRepository.findById(categoryId).orElse(null);
	}
	
	
	//delete 
	
	public boolean deleteCategoryById(long categoryId) {
		boolean status=false;
		this.categoryRepository.deleteById(categoryId);
		
		if(this.getCategoryById(categoryId)==null)
			status=true;
		
		return status;
	}
	
	public Category updateCategory(long categoryId, String categoryName) {
		Category category=this.getCategoryById(categoryId);
		category.setCategoryName(categoryName);
		return this.categoryRepository.save(category);
	}
	
}
