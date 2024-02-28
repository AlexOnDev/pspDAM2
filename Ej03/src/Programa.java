
public class Programa {

	public static void main(String[] args) {
		Contador contador = new Contador(true); //Clase ThreadSafe ya que usa synchronized
		HiloDescontador h1 = new HiloDescontador(1000, contador);
		HiloDescontador h2 = new HiloDescontador(1000, contador);
		Thread h3= new Thread(new HiloContador(2000, contador)); //Thread porque Contador implementa Runnable y no extends Thread
		Thread h4= new Thread(new HiloContador(2000, contador));

		h1.start();
		h2.start();
		h3.start();
		h4.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
			h4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(contador);

	}

}
