package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@Repository
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	SessionFactory sf;
	
	Session s;
	Transaction t;
	
	public boolean addUser(UserDetails u) {

		try{
			s = sf.openSession();
			t = s.beginTransaction();
			u.setEnabled(true);
			u.setRole("ROLE_USER");
			s.save(u);
			t.commit();
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public boolean delUser(int uid) {
		UserDetails u;
		try{
			s = sf.openSession();
			t = s.beginTransaction();
			u = (UserDetails)s.load(UserDetails.class, uid);
			s.delete(u);
			t.commit();
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public boolean updUser(UserDetails u) {
		UserDetails u1;
		try{
			s = sf.openSession();
			t = s.beginTransaction();
			u1 = (UserDetails)s.load(UserDetails.class, u.getUid());
			u1.setUname(u.getUname());
			u1.setUpass(u.getUpass());
			u1.setUaddr(u.getUaddr());
			s.saveOrUpdate(u1);
			t.commit();
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public UserDetails getUserById(int uid) {
		UserDetails u;
		try{
			s = sf.openSession();
			t = s.beginTransaction();
			u = (UserDetails)s.load(UserDetails.class, uid);
			t.commit();
			return u;
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> getAllUsers() {
		List<UserDetails> l;
		try{
			s = sf.openSession();
			t = s.beginTransaction();
			l = (List<UserDetails>)s.createQuery("from UserDetails").getResultList();
			t.commit();
			return l;
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

}
