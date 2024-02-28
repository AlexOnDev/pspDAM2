package model;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1903788484698268092L;
	
	String nombre;
	int edad;
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
	

}
