package OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	private int id;
	private String pname;
	@ManyToOne
	private Seller sname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Seller getSname() {
		return sname;
	}
	public void setSname(Seller sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", sname=" + sname + "]";
	}
	
	
}
