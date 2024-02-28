
public class Pagador extends Thread{

	private Cuenta c;
	private Object aviso;
	
	public Pagador(Cuenta c, Object aviso) {
		super();
		this.c = c;
		this.aviso = aviso;
	}

	public void run() {
		try {
			for(int i=0; i<3; i++) {
				c.annadirDinero(1000);
				Thread.sleep(5000);
			}
			synchronized (aviso) {
				aviso.notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
