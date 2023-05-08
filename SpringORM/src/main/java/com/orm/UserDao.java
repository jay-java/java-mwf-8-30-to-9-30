package com.orm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


public class UserDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void insertUser(User u) {
		this.hibernateTemplate.save(u);
	}
	@Transactional
	public void updateUser(User u ) {
		this.hibernateTemplate.update(u);
	}
	@Transactional
	public void deleteUer(User u) {
		this.hibernateTemplate.delete(u);
	}
	
	public User getUserById(int id) {
		return this.hibernateTemplate.get(User.class, id);
	}
	
	public List<User> getAllUser(){
		 return this.hibernateTemplate.loadAll(User.class);
	}
}
