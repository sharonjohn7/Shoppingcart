package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.UserDetails;

public interface UserDetailsDAO {

	boolean addUser(UserDetails u);
	boolean delUser(int uid);
	boolean updUser(UserDetails u);
	UserDetails getUserById(int uid); 
	List<UserDetails> getAllUsers();
}
