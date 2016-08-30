package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {
	boolean addCat(Category c);
	boolean delCat(int id);
	boolean updCat(Category c);
	Category getCatById(int id);
	List<Category> getAllCats();
}
