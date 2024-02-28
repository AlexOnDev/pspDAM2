
public class HiloContador implements Runnable {
	
	private int vueltas;
	private Contador contador;
	
	public HiloContador(int vueltas, Contador contador) {
		super();
		this.vueltas = vueltas;
		this.contador = contador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < vueltas; i++) {
			synchronized (contador) { //Todos los objetos tienen un "lock" y si esta abierto lo cierra y hace el metodo contar()
				contador.contar();
				
			}
		}

	}

}
