package gal.teis.model;

public class VehiculoAbonado extends Vehiculo {

	public VehiculoAbonado(String id) {
		super(id);
	}

	@Override
	public double factura() {
		return tiempo * 200.0;
	}

}
