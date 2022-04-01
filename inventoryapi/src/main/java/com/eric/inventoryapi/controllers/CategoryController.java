package com.eric.inventoryapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.inventoryapi.models.Category;
import com.eric.inventoryapi.services.CategoryService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
	private CategoryService categoryService;
    private Gson gson;
	
	//save
	@PostMapping({"/v1.0", "/v1.1"})
	//http://localhost:7070/categories/v1.0
	//http://localhost:7070/categories/v1.1
	public ResponseEntity<String> addCategory(@RequestBody Category category){
		Category catObj=this.categoryService.addCategory(category);
		gson=new Gson();
		if(catObj!=null)
 		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson(catObj));
		else
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category not created");
	}
    
	
	@GetMapping({"/v1.0"})
	//retrieve all
	public List<Category> getAllCategories(){
		return this.categoryService.getAllCategories();
	}
	
	//retrieve by id
	
	@GetMapping({"/v1.0/{categoryId}"})	
	public ResponseEntity<String> getCategoryById(@PathVariable("categoryId") long categoryId){
		Category catObj=this.categoryService.getCategoryById(categoryId);
		gson=new Gson();
		if(catObj!=null)
 		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson(catObj));
		else
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category not found");
	}
	
	
	//delete
	@DeleteMapping({"/v1.0/{categoryId}"})	
	public ResponseEntity<String> deleteCategoryById(@PathVariable("categoryId") long categoryId){
		
		if(this.categoryService.deleteCategoryById(categoryId))
 		 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Category Deleted");
		else
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category not found");
	}
	
	@PutMapping({"/v1.0/{categoryId}/{categoryName}"})	
	public ResponseEntity<String> updateCategoryById(
			@PathVariable("categoryId") long categoryId, @PathVariable("categoryName") 
			String categoryName){
		Category catObj=this.categoryService.updateCategory(categoryId, categoryName);
		gson=new Gson();
		if(catObj!=null)
 		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson(catObj));
		else
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category could not be updated");
	}
	
	
}
