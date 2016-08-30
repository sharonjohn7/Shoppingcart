package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sf;
	
	Session s;
	Transaction t;

	public boolean addProd(Product p) {
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		s.save(p);
		t.commit();
		return true;
	}
        catch(Exception e){
        	System.out.println(e);
        	return false;
            }
        }
	public boolean delProd(int pid) {
		Product p;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		p=(Product)s.load(Product.class,pid);
		s.delete(p);
		t.commit();
		return true;
		}
		catch(Exception e){
        System.out.println(e);
        return false;
		}
	}

	public boolean updProd(Product p) {
		Product p1;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		p1=(Product)s.load(Product.class,p.getId());
		p1.setCatId(p.getCatId());
		p1.setName(p.getName());
		p1.setPrice(p.getPrice());
		p1.setQuantity(p.getQuantity());
		s.saveOrUpdate(p);
		t.commit();
		return true;
	}
        catch(Exception e){
        	System.out.println(e);
        	return false;
        }
	}
	public Product getProdById(int pid) {
		Product p;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		p = (Product)s.load(Product.class, pid);
		t.commit();
		return p;
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	}
	}
	@SuppressWarnings("unchecked")
	public List<Product> getAllProds() {
		List<Product> l;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		l = (List<Product>)s.createQuery("from Product").getResultList();
		t.commit();
		return l;
	}
catch(Exception e){
	System.out.println(e);
	return null;
}
}
	
}
