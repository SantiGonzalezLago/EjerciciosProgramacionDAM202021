package gal.teis.model;

public abstract class Vehiculo {
	protected String id;
	protected int tiempo;

	public Vehiculo(String id) {
		this.id = id;
		tiempo = 0;
	}

	public String getId() {
		return id;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	abstract public double factura();
}
