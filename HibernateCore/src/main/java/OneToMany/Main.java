package OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String[] args) {
	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	
	Seller s1 = new Seller();
	s1.setId(1);
	s1.setName("java");
	
	Product p1 =new Product();
	p1.setId(1);
	p1.setPname("shoes");
	
	Product p2 =new Product();
	p2.setId(2);
	p2.setPname("laptop");
	
	List<Product> plist = new ArrayList<Product>();
	plist.add(p1);
	plist.add(p2);
	
	s1.setProducts(plist);
	p1.setSname(s1);
	p2.setSname(s1);
	
	session.save(s1);
	session.save(p1);
	session.save(p2);
	
	tx.commit();
	session.close();
	sf.close();
}
}
