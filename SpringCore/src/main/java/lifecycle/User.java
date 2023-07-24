package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class User{
	private int id;
	private String name;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@PostConstruct
	public void start() {
		System.out.println("bean started");
	}
	@PreDestroy
	public void stops() {
		System.out.println("bean stopped");
	}
	

//	public void afterPropertiesSet() throws Exception {
//		System.out.println("bean started");
//	}
//
//	public void destroy() throws Exception {
//		System.out.println("bean stopped");
//	}

//	public void start() {
//		System.out.println("bean started");
//	}
//	public void stops() {
//		System.out.println("bean stopped");
//	}
}
