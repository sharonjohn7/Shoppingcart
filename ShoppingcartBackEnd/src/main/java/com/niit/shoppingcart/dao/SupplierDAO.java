package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;


public interface SupplierDAO {
	boolean addSupp(Supplier sup);
	boolean delSupp(int id);
	boolean updSupp(Supplier sup);
	Supplier getSuppById(int id);
	List<Supplier> getAllSupps();

}
