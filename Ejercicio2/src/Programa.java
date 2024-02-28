import java.util.Random;

public class Programa {

	public static void main(String[] args) {
		Cuenta c =new Cuenta(1000);
		Object aviso=new Object();
		Pagador p=new Pagador(c, aviso);
		p.start();
		Cliente c1=new Cliente("Pepe", aviso, c);
		Cliente c2=new Cliente("Ana", aviso, c);
		c1.start();
		c2.start();
	
		try {
			p.join();	
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(c);
	}
}
