class CallBack {
	public void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	Thread t;
	String msg;
	CallBack c;

	Caller(String msg, CallBack c) {
		this.msg = msg;
		this.c = c;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		synchronized (c) {
			c.call(msg);
		}
	}

}

public class SyncDemo {
	public static void main(String[] args) {
		CallBack c = new CallBack();
		Caller c1 = new Caller("first", c);
		Caller c2 = new Caller("second", c);
		Caller c3 = new Caller("third", c);
	}
}
