
class NewThread extends Thread{
	Thread t;
	NewThread(){
		t = new Thread(this);
		t.start();
	}
	public void run() {
		for(int i=1;i<=5;i++) {
			try {
				System.out.println(t+" "+i);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("child thred");
	}
}
public class threademo {
	public static void main(String[] args) {
		new NewThread();
		Thread t = new Thread();
		System.out.println(t.currentThread());
		t.setName("MyThred");
		for(int i=1;i<=5;i++) {
			try {
				System.out.println(t+" "+i);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("main thread");
	}
}
