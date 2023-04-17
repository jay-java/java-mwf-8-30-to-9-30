package connection;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DBConnection {
    Session session = null;
	Properties prop = null;
	Configuration cfg = null;
	public Session getSession() {
		prop = new Properties();
		prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatecore");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.setProperty("hibernate.show_sql", "true");
		
		cfg = new Configuration();
		cfg.setProperties(prop).buildSessionFactory();
		return session;
	}
}
