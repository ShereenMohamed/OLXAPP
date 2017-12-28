package com.olx.controller;

import java.util.Set;
import java.util.Set;

import com.olx.model.Category;

public class CategoryService {
	private CategoryController categoryController;
	public CategoryService(){
		this.categoryController=new CategoryController();
	}
	public Set<Category> ListOfCategories(){
		Set<Category> categories = categoryController.ListOfCategories();
		return categories;
	}
}
