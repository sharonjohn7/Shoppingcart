package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sf;

	Session s;
	Transaction t;

	public boolean addSupp(Supplier sup) {
		try {
			s = sf.openSession();
			t = s.beginTransaction();
			s.save(sup);
			t.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public boolean delSupp(int id) {
		Supplier sup;
		try {
			s = sf.openSession();
			t = s.beginTransaction();
			sup = (Supplier) s.load(Supplier.class, id);
			s.delete(sup);
			t.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updSupp(Supplier sup) {
		Supplier s1;
		try {
			s = sf.openSession();
			t = s.beginTransaction();
			s1 = (Supplier) s.load(Supplier.class, sup.getId());
			s1.setName(sup.getName());
			s.saveOrUpdate(sup);
			t.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Supplier getSuppById(int id) {
		Supplier sup;
		try {
			s = sf.openSession();
			t = s.beginTransaction();
			sup = (Supplier) s.load(Supplier.class, id);
			t.commit();
			return sup;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSupps() {
		List<Supplier> l;
		try {
			s = sf.openSession();
			t = s.beginTransaction();
			l = (List<Supplier>) s.createQuery("from Supplier").getResultList();
			t.commit();
			return l;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
