package com.olx.model;

public class CategoryDtoReq {
	private int id;
	private String name;

	public CategoryDtoReq(int id) {
		// TODO Auto-generated constructor stub
		this.id =id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
