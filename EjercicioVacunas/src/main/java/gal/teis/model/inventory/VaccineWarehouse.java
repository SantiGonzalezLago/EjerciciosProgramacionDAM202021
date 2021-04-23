package gal.teis.model.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import gal.teis.model.vaccines.Vaccine;

public final class VaccineWarehouse {

	private static ArrayList<Vaccine> warehouse = new ArrayList<>();
	private static int total = 0;

	public int getTotal() {
		return total;
	}

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

	public static Vaccine[] getVaccines() {
		return Arrays.copyOf(warehouse.toArray(new Vaccine[warehouse.size()]), warehouse.size());
	}

	public static Vaccine[] getAuthorizedVaccines() {
		var authVaccines = new ArrayList<Vaccine>();
		for (Vaccine v : warehouse) {
			if (v.isAuthorized()) {
				authVaccines.add(v);
			}
		}
		return authVaccines.toArray(new Vaccine[authVaccines.size()]);
	}

	public static Vaccine[] getUnauthorizedVaccines() {
		var unauthVaccines = new ArrayList<Vaccine>();
		for (Vaccine v : warehouse) {
			if (v.isUnauthorized()) {
				unauthVaccines.add(v);
			}
		}
		return unauthVaccines.toArray(new Vaccine[unauthVaccines.size()]);
	}

	public static Vaccine[] getPendingVaccines() {
		var pendingVaccines = new ArrayList<Vaccine>();
		for (Vaccine v : warehouse) {
			if (!v.isAuthorized() && !v.isUnauthorized()) {
				pendingVaccines.add(v);
			}
		}
		return pendingVaccines.toArray(new Vaccine[pendingVaccines.size()]);
	}

	public static void printLastCompletedPhaseOfEachVaccine() {
		for (Vaccine v : warehouse) {
			StringBuilder sb = new StringBuilder();
			sb.append(v.getCode());
			sb.append(":\tFase ");
			sb.append(v.getCompletedPhases());
			System.out.println(sb);
		}
	}

	public static Vaccine getVaccine(String code) {
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

	// La clase utilizará métodos estáticos, añado un constructor privado para que
	// no se pueda instanciar
	private VaccineWarehouse() {
	}

}
