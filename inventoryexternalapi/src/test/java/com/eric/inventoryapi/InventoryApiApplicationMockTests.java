package com.eric.inventoryapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.hamcrest.Matchers;
import com.eric.inventoryapi.models.Category;
import com.eric.inventoryapi.services.CategoryService;

@WebMvcTest
@RunWith(SpringRunner.class)
public class InventoryApiApplicationMockTests {
	
	 @Autowired
	 private MockMvc mockMvc;	  

	@MockBean
	private CategoryService categoryService;
	
	@Test
	public void mockGetCategories() throws Exception {
		
		//Given when then
		Mockito.when(categoryService.getAllCategories()).thenReturn(getFakeCategories());
		mockMvc.perform(get("/categories/v1.0"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(4)))
		.andExpect(jsonPath("$[3].categoryName", Matchers.startsWith("Jewellery")));
	}
	
	
	//fake
	
	public List<Category> getFakeCategories(){
		
		List<Category> categoryList=new ArrayList<Category>();
		categoryList.add(new Category(1,"Electronics"));
		categoryList.add(new Category(2,"Cosmetics"));
		categoryList.add(new Category(3,"Furniture"));
		categoryList.add(new Category(4,"Jewellery"));
		
		return categoryList;
	}
	

}
