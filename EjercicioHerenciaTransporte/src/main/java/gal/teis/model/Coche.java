package gal.teis.model;

public class Coche extends Vehiculo {
	protected String nombre = "turismo";
	
	public void printName() {
		System.out.println(nombre);
		System.out.println(super.nombre);
	}
}
