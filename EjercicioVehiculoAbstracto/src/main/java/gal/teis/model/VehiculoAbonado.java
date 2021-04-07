package gal.teis.model;

public class VehiculoAbonado extends Vehiculo {

	public VehiculoAbonado(String id) {
		super(id);
	}

	@Override
	public double factura() {
		return tiempo * 200.0;
	}

	public double factura(String codigo) {
		return 0.97 * factura();
	}

}
