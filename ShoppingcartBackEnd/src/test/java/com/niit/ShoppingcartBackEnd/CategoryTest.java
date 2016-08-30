package com.niit.ShoppingcartBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		CategoryDAO cate=(CategoryDAO) context.getBean("CategoryDAO");
		Category c=new Category();
		c.setId(100);
		c.setName("Electronics");
		
		if(cate.addCat(c)){
			System.out.println("Category Added Successfully");
			c.setId(101);
			c.setName("Laptop");
			cate.addCat(c);
		}
		else{
			System.out.println("Unable to Add Category");
		}
		Category c1=cate.getCatById(4);
		if(c1 != null)
		{
			c1.setId(102);
			c1.setName("Mobile");
			if(cate.updCat(c1)){
				System.out.println("Category Updated Successfully");
			}
			else{
				System.out.println("Unable to Update User.");
			}
		}
		else{
			System.out.println("No Object with Id 1");
		}
		List<Category> l=cate.getAllCats();
		if(!l.isEmpty()){
			for(Category x:l)
				System.out.println(x);
		}
		else
		{
			System.out.println("No Data Found");
		}
		
		if(cate.delCat(2)){
			System.out.println("Category Deleted Successfully");
		}
		else{
			System.out.println("Unable to Delete Category");
		}
		context.close();

	}

}
