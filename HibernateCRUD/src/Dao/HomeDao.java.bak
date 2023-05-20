package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Bean.UserBean;
import Util.UserUtil;

public class HomeDao {
	Session session = null;
	Transaction tx = null;
	List<UserBean> li = null;
	UserBean u = null;
	public UserBean doLogin(int uid) {
		try {
			session = new UserUtil().getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from UserBean u where u.uid=:uid");
			q.setParameter("uid", uid);
			li = q.list();
			u = li.get(0);
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			u=null;
			e.printStackTrace();
		}
		return u;
	}
	public void updateUser(UserBean u) {
		session = new UserUtil().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("update UserBean u set u.fname=?1,u.lname=?2,u.email=?3,u.password=?4 where u.uid=?5");
		q.setParameter(1, u.getFname());
		q.setParameter(2, u.getLname());
		q.setParameter(3, u.getEmail());
		q.setParameter(4, u.getPassword());
		q.setParameter(5, u.getUid());
		q.executeUpdate();
		tx.commit();
		session.close();
	}
	public void deleteUser(int id) {
		session = new UserUtil().getSession();
		tx= session.beginTransaction();
		Query q = session.createQuery("delete from UserBean u where u.uid=?1");
		q.setParameter(1, id);
		q.executeUpdate();
		tx.commit();
		session.close();
	}
}
