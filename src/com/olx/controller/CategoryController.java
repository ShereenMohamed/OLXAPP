package com.olx.controller;

import java.util.HashSet;
import java.util.Set;

import com.olx.model.Category;
import com.olx.model.CategoryDtoRes;

public class CategoryController {
	private CategoryDao categoryDao;
	
	public CategoryController(){
		this.categoryDao=new CategoryDao();
	}
	public Set<Category> ListOfCategories(){
		Set<Category> categories =new HashSet<Category>();
		
		Set<CategoryDtoRes> categoriess=categoryDao.findAll();
		for(CategoryDtoRes categ:categoriess){
			Category category= new Category();
			category=categ.getCategory();
			categories.add(category);
		}
		return categories;
	}
}
