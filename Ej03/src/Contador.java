
public class Contador {
	private boolean positivo;
	private int numero;
	
	public Contador(boolean positivo) {
		super();
		this.positivo=positivo;
		this.numero=0;
	}
	public void contar() {
		if(positivo) {
			synchronized (this) { //Igual que en las dos clases Hilo... y el objeto es él mismo
				this.numero++;
			}
		}else {
			synchronized (this) {
				this.numero--;

			}
		}
	}
	public synchronized void descontar() { //synchronized en el metodo aunque sincroniza todo (desventaja)
		if(!positivo) {
				this.numero++;
			
		}else {
				this.numero--;

			
		}
	}
	@Override
	public String toString() {
		return "Contador [positivo=" + positivo + ", numero=" + numero + "]";
	}

}
