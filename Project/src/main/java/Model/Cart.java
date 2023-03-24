package Model;

public class Cart {
	private int cid, pid, cusid;
	private String pname, pprice;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", cusid=" + cusid + ", pname=" + pname + ", pprice=" + pprice
				+ "]";
	}
}
