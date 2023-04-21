package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.DBConnection;
import model.User;

public class UserDao {
	Session session = null;
	Transaction tx = null;
	List<User> list = null;
	public void insertUser(User u) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
		System.out.println("data inserted");
	}
	public User userLogin(User u) {
		User u1 = null;
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from User u where u.email=:email and u.password=:password");
		q.setParameter("email", u.getEmail());
		q.setParameter("password", u.getPassword());
		list = q.list();
		u1 = list.get(0);
		tx.commit();
		session.close();
		return u1;
	}
	public List<User> getAllUser(){
		list = new ArrayList<User>();
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from User");
		list = q.list();
		return list;
	}
	public void updateUser(User u) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("update User u set u.name=:name,u.contact=:contact where u.id=:id");
		q.setParameter("name", u.getName());
		q.setParameter("email", u.getEmail());
		q.setParameter("password", u.getPassword());
		list = q.list();
		u = list.get(0);
		tx.commit();
		session.close();
	}
	public void deleteUser(int id) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("delete from User u where u.id=:id");
		q.setParameter("id", id);
		tx.commit();
		session.close();
	}
}
