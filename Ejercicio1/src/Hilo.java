
public class Hilo extends Thread{

	public void run() {
		try {
			Thread.sleep(500);
			System.out.println(getName());
			synchronized(this) {
				this.notify();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
