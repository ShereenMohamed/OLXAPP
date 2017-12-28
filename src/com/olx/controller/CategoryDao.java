package com.olx.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.olx.model.CategoryDtoRes;
import com.olx.model.User;
import com.olx.model.UserDtoRes;
import com.olx.model.Category;

public class CategoryDao implements ICategoryDao{
	public Connection con;
	private Statement stmt;
	public CategoryDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/OLX","root","root");
		
			stmt= con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in connection with db");
			e.printStackTrace();
		}
	}
	@Override
	public Set<CategoryDtoRes> findAll() {
		ResultSet rs;
		Set<CategoryDtoRes> categories = new HashSet<CategoryDtoRes>();
		
		try {
			
			rs = stmt.executeQuery("select id,name from Category");
			while(rs.next()){
				Category category = new Category();
				CategoryDtoRes categoryy = new CategoryDtoRes();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				categoryy.setCategory(category);
				categoryy.setResult(true);
				categories.add(categoryy);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return categories;
	}
	@Override
	public CategoryDtoRes find(String name) {
		ResultSet rs;
		CategoryDtoRes catt = new CategoryDtoRes();
		try {
			
			rs = stmt.executeQuery("select id,name from Category where category.name = '"+name+"'");
			
			while(rs.next()){
				Category cat = new Category();
				cat.setId(rs.getInt(1));
				cat.setName(rs.getString(2));
			
				catt.setCategory(cat);
				catt.setResult(true);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return catt;
	}

}
