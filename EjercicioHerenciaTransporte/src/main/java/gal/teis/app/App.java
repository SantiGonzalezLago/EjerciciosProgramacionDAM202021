package gal.teis.app;

import gal.teis.model.*;

public class App {
	public static void main(String[] args) {
		new Coche().printName();

		// new Vehiculo().acelerar(); No se puede porque tiene visibilidad protected
		new Coche().acelerar();
		new Moto().acelerar();
		new Camión().acelerar();
	}
}
