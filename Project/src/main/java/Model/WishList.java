package Model;

public class WishList {
	private int wid,pid,cusid;

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
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

	@Override
	public String toString() {
		return "WishList [wid=" + wid + ", pid=" + pid + ", cusid=" + cusid + "]";
	}
	
}
