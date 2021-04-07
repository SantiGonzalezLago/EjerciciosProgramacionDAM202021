package gal.teis.model;

public class VehiculoCliente extends Vehiculo {

	public VehiculoCliente(String id) {
		super(id);
	}

	@Override
	public double factura() {
		return (tiempo / 24) * 12.0 + (tiempo % 24) * 0.6;
	}

}
