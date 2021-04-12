package gal.teis.model.inventory;

import java.util.ArrayList;
import java.util.Objects;

import gal.teis.model.vaccines.Vaccine;

public final class VaccineOps {

	private static ArrayList<Vaccine> warehouse = new ArrayList<>();
	private static int total = 0;

	public static boolean add(Vaccine vaccine) {
		boolean elementExists = false;
		int idx = 0;
		while (idx < warehouse.size() && !elementExists) {
			elementExists = warehouse.get(idx).equals(vaccine);
			idx++;
		}
		if (!elementExists) {
			warehouse.add(vaccine);
			total++;
		}
		return !elementExists;
	}

	public static boolean remove(String code) {
		boolean success = false;
		Vaccine removed = getVaccine(code);
		if (Objects.nonNull(removed)) {
			warehouse.remove(removed);
			total--;
			success = true;
		}
		return success;
	}

	//	TODO
	//	• Método que permitirá introducir el resultado de las tres fases de prueba
	//	necesarias para autorizar una vacuna.	
	//	• Método que muestra el listado completo de vacunas con la información de los
	//	atributos comunes a todas las vacunas.
	//	• Método que muestre el listado de todas las vacunas con su nombre, código y
	//	si están aprobadas o no.
	//	• Método que muestre el listado de las vacunas autorizadas (nombre y código).
	//	• Método que muestre el listado de las vacunas no autorizadas (nombre y
	//	código).
	//	• Método que muestre el listado de las vacunas pendientes de autorización
	//	(nombre y código).
	//	• Método que busque una vacuna en función de su código y nos informe de si
	//	está autorizada, rechazada o pendiente de autorización

	private static Vaccine getVaccine(String code) {
		Vaccine vaccine = null;
		int idx = 0;
		while (idx < warehouse.size() && Objects.isNull(vaccine)) {
			if (warehouse.get(idx).getCode().equals(code)) {
				vaccine = warehouse.get(idx);
			}
			idx++;
		}
		return vaccine;
	}

	// La clase utilizará métodos estáticos, añado un constructor privado para que no se pueda instanciar
	private VaccineOps() {
	}

}
