import java.util.Random;

public class Cliente extends Thread {

	private String name;
	private Object aviso;
	private Cuenta c;
	
	public Cliente(String name, Object aviso, Cuenta c) {
		super();
		this.name = name;
		this.aviso = aviso;
		this.c = c;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			Random r1=new Random();
			int num=r1.nextInt(300);
			while(num<100) {
				num=r1.nextInt(300);
			}
			if(c.muestraDinero()>=num) {
				System.out.println("Soy" + name + ": " + (c.muestraDinero()-num));
				c.extraerDinero(num);
			}else{
				synchronized (aviso) {
					try {
						aviso.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
