package Dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import Bean.UserBean;
import Util.UserUtil;

public class UserDao {
	Session session = null;
	Transaction tx = null;
	String msg="";
	public String doRegister(UserBean u) {
		try {
			session = new UserUtil().getSession();
			tx = session.beginTransaction();
			session.save(u);
			tx.commit();
			session.close();
			msg = "data registered";
		} catch (Exception e) {
			// TODO: handle exception
			msg= "error";
			e.printStackTrace();
		}
		return msg;
	}
}
