import java.util.ArrayList;

public class Programa {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Hilo> lista=new ArrayList<>();
		for(int i=0; i<10; i++) {
			lista.add(new Hilo());
		
		}
		for(Hilo h: lista) {
			h.start();
			synchronized(h) {
				h.wait();
			}
			try {
				Thread.sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(Hilo h1: lista) {
			try {
				System.out.println("Finalizado");
				h1.join();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
