package com.niit.ShoppingcartBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;


public class UserTest {

	public static void main(String[] args) {
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		UserDetailsDAO ud = (UserDetailsDAO) context.getBean("userDetailsDAO");
		
		UserDetails u = new UserDetails();
		u.setUname("Arut");
		u.setUpass("123456");
		u.setUaddr("chennai");
		
		if(ud.addUser(u)){
			System.out.println("User Added Successfully");
			u = new UserDetails();
			u.setUname("Arut1");
			u.setUpass("12345");
			u.setUaddr("chn");
			ud.addUser(u);
		}
		else{
			System.out.println("Unable to Add User.");
		}
		
		UserDetails u1 = ud.getUserById(3);
		
		if(u1 != null)
		{
			u1.setUname("Arutselvan");
			u1.setUaddr("TVM");
		
			if(ud.updUser(u1)){
				System.out.println("User Updated Successfully");
			}
			else{
				System.out.println("Unable to Update User.");
			}
		}
		else{
			System.out.println("No Object with Id 1");
		}
		
		List<UserDetails> l = ud.getAllUsers();
		
		if(!l.isEmpty()){
			for(UserDetails x : l)
				System.out.println(x);
		}
		else{
			System.out.println("No Data Found");
		}
		
		if(ud.delUser(2)){
			System.out.println("User Deleted Successfully");
		}
		else{
			System.out.println("Unable to Delete User.");
		}

		context.close();
	}


}
