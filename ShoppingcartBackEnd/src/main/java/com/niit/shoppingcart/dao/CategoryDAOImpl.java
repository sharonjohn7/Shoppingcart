package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sf;
	
	Session s;
	Transaction t;
	
	public boolean addCat(Category c) {
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		s.save(c);
		t.commit();
		return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		
	}

	public boolean delCat(int cid) {
		Category c;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		c=(Category)s.load(Category.class, cid);
		s.delete(c);
		t.commit();
		return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public boolean updCat(Category c) {
		Category c1;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		c1=(Category)s.load(Category.class, c.getId());
		c1.setId(c.getId());
		c1.setName(c.getName());
		s.saveOrUpdate(c);
		t.commit();
		return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		
	}
    public Category getCatById(int id) {
		Category c;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		c = (Category)s.load(Category.class, id);
		t.commit();
		return c;
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCats() {
		List<Category> l;
		try{
		s = sf.openSession();
		t = s.beginTransaction();
		l=(List<Category>)s.createQuery("from Category").getResultList();
		t.commit();
		return l;
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

}
