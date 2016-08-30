package com.niit.ShoppingcartBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		SupplierDAO supdao = (SupplierDAO) context.getBean("SupplierDAO");
		Supplier sup = new Supplier();
		sup.setId(1);
		sup.setName("Dell Co.");
		if (supdao.addSupp(sup)) {
			System.out.println("Product Added Sucessfully");
			sup = new Supplier();
			sup.setId(2);
			sup.setName("Lenovo");
		} else {
			System.out.println("Unable to add Supplier");
		}
		Supplier s1 = supdao.getSuppById(3);
		if (s1 != null) {
			sup.setId(4);
			sup.setName("Dell Co");
			if (supdao.updSupp(s1)) {
				System.out.println("Supplier Updated Successfully");
			} else {
				System.out.println("Unable to Update Supplier");
			}
		} else {
			System.out.println("No Object with Id 1");
		}
		List<Supplier> l = supdao.getAllSupps();
		if (!l.isEmpty()) {
			for (Supplier x : l)
				System.out.println(x);
		} else {
			System.out.println("No Data Found");
		}
		if (supdao.delSupp(2)) {
			System.out.println("Supplier Deleted Sucessfully");
		} else {
			System.out.println("Unable to Delete Supplier");
		}
		context.close();
	}
}
