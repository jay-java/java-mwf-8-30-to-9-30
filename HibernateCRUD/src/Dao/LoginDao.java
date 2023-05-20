package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Bean.UserBean;
import Util.UserUtil;

public class LoginDao {
	Session session = null;
	Transaction tx = null;
	List<UserBean> list = null;
	UserBean u = null;
	public UserBean doLogin(UserBean u) {
		try {
			session = new UserUtil().getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from UserBean u where u.email=:email and u.password=:password");
			q.setParameter("email", u.getEmail());
			q.setParameter("password", u.getPassword());
			list = q.list();
			u = list.get(0);
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			u = null;
			e.printStackTrace();
		}
		return u;
	}
}
