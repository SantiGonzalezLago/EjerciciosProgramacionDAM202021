package gal.teis.model.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import gal.teis.model.vaccines.Vaccine;

public final class VaccineWarehouse {

	private static Map<String, Vaccine> warehouse = new HashMap<>();
	private static int total = 0;

	public int getTotal() {
		return total;
	}

	public static boolean add(Vaccine vaccine) {
		boolean success = false;
		if (Objects.isNull(warehouse.get(vaccine.getCode()))) {
			warehouse.put(vaccine.getCode(), vaccine);
			total++;
			success = true;
		}
		return success;
	}

	public static boolean remove(String code) {
		return Objects.nonNull(warehouse.remove(code));
	}

	public static Vaccine[] getVaccines() {
		return warehouse.values().toArray(new Vaccine[warehouse.size()]);
	}

	public static List<Vaccine> getAuthorizedVaccines() {
		var authVaccines = new ArrayList<Vaccine>();
		for (var pair : warehouse.entrySet()) {
			Vaccine v = pair.getValue();
			if (v.isAuthorized()) {
				authVaccines.add(v);
			}
		}
		return authVaccines;
	}

	public static List<Vaccine> getUnauthorizedVaccines() {
		var unauthVaccines = new ArrayList<Vaccine>();
		for (var pair : warehouse.entrySet()) {
			Vaccine v = pair.getValue();
			if (v.isUnauthorized()) {
				unauthVaccines.add(v);
			}
		}
		return unauthVaccines;
	}

	public static List<Vaccine> getPendingVaccines() {
		var pendingVaccines = new ArrayList<Vaccine>();
		for (var pair : warehouse.entrySet()) {
			Vaccine v = pair.getValue();
			if (!v.isAuthorized() && !v.isUnauthorized()) {
				pendingVaccines.add(v);
			}
		}
		return pendingVaccines;
	}

	public static Vaccine getVaccine(String code) {
		return warehouse.get(code);
	}

	// La clase utilizará métodos estáticos, añado un constructor privado para que  no se pueda instanciar
	private VaccineWarehouse() {
	}

}
