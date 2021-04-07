package gal.teis.model;

public abstract class Vehiculo {
	protected String id;
	protected int tiempo;
	
	public Vehiculo(String id) {
		this.id = id;
		tiempo = 0;
	}

	public double factura(int tiempo) {
		this.tiempo = tiempo;
		return factura();
	}

	abstract public double factura();
}
