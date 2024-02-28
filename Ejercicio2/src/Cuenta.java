
public class Cuenta {

	private int dinero;
	private int movimientos=0;
	
	public Cuenta(int dinero) {
		super();
		this.dinero = dinero;
	}
	
	public int muestraDinero() {
			
			return dinero;
		
	}
	public void extraerDinero(int n) {
		synchronized (this) {
			dinero-=n;
			movimientos++;
		}
	}
	public void annadirDinero(int n) {
		synchronized (this) {
			dinero+=n;		
			movimientos++;
			
		}
	}
	@Override
	public String toString() {
		return "Cuenta [dinero=" + dinero + ", movimientos=" + movimientos + "]";
	}
	
	
	
}
