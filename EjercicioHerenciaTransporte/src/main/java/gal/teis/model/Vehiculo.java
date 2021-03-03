package gal.teis.model;

public class Vehiculo extends Transporte {
	protected String nombre = "carretera";
	
	protected void acelerar() {
		System.out.println("Acelerando el vehículo");
	}
}
