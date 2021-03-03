package gal.teis.model;

public class Coche extends Vehiculo {
	protected String nombre = "turismo";
	
	public void printName() {
		System.out.println(nombre);
		System.out.println(super.nombre);
		System.out.println(((Transporte)this).nombre);
	}

	@Override
	public void acelerar() {
		System.out.println("Acelerando el coche");
	}
}
