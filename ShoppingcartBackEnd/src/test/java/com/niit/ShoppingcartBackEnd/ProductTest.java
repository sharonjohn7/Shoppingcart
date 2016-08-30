package com.niit.ShoppingcartBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {

	public static void main(String[] args) {
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		ProductDAO prdao=(ProductDAO) context.getBean("ProductDAO");
		
		Product pr=new Product();
		pr.setCatId(100);
		pr.setId(1000);
		pr.setName("Dell Laptop");
		pr.setPrice(30000);
		pr.setQuantity(1);
		if(prdao.addProd(pr)){
			System.out.println("Product Added Successfully");
			pr=new Product();
			pr.setCatId(100);
			pr.setId(1001);
			pr.setName("Dell Laptop");
			pr.setPrice(40000);	
		}
		else{
			System.out.println("Unable to add Product");
		}
		
		Product p1=prdao.getProdById(3);
		if(p1 != null)
		{
			pr.setId(1002);
			pr.setName("Dell Laptop");
			pr.setPrice(35000);
			if(prdao.updProd(p1)){
				System.out.println("Product Updated Successfully");
			}
			else{
				System.out.println("Unable to Update Product");
			}
		}
		else{
			System.out.println("No Object with Id 1");
		}
		List<Product> l=prdao.getAllProds();
		if(!l.isEmpty()){
			for(Product x:l)
				System.out.println(x);
		}
		else{
			System.out.println("No Data Found");
		}
		if(prdao.delProd(2)){
			System.out.println("Product Deleted Successfully");
		}
		else{
			System.out.println("Unable to Delete Product.");
		}
		context.close();

	}

}
