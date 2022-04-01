package com.eric.inventoryapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import com.eric.inventoryapi.models.Category;
import com.eric.inventoryapi.repositories.CategoryRepository;

@SpringBootTest
@AutoConfigureTestEntityManager
@Rollback(false)
class InventoryapiApplicationTests {

	private static Category category;
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CategoryRepository categoryRepository;
	
	//before executing all test cases, execute this method
	@BeforeAll
	public static void getCategoryInstance() {
	      category=new Category();
	}
	
	@Test
	@DisplayName("Category Null or Not")
	@RepeatedTest(5)
	void testCategoryInstanceNUllorNot() {
	   assertNotNull(category);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Electronics","Garments","Furniture"})
	void testCategoryNameStartsWithE(String name) {
		category.setCategoryName(name);
		assertTrue(category.getCategoryName().startsWith("E"));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "./Catalog.csv",numLinesToSkip = 1)
	@Transactional
	void testCategoryEntitySavedOrNot(String name) {
		Category category=new Category();
		category.setCategoryName(name);
		this.entityManager.persist(category);
		this.entityManager.flush();
	   assertTrue(this.categoryRepository.findAll().size()>3);
	}
}
