package connection;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class DBConnection {
    Session session = null;
	Properties prop = null;
	Configuration cfg = null;
	SessionFactory sf = null;
	public Session getSession() {
		prop = new Properties();
		prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatecore");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		cfg = new Configuration();
		cfg.setProperties(prop).addAnnotatedClass(User.class);
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		return session;
	}
}
