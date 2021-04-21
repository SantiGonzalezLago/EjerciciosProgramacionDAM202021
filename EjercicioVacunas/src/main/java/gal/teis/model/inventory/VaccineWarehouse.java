package gal.teis.model.inventory;

import java.util.ArrayList;
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

	public static void printVaccines() {
		for (Vaccine v : warehouse) {
			System.out.println(v);
		}
	}

	public static void printAuthorizedVaccines() {
		for (Vaccine v : warehouse) {
			if (v.isAuthorized()) {
				System.out.println(v);
			}
		}
	}

	public static void printUnauthorizedVaccines() {
		for (Vaccine v : warehouse) {
			if (v.isUnauthorized()) {
				System.out.println(v);
			}
		}
	}

	public static void printPendingVaccines() {
		for (Vaccine v : warehouse) {
			if (!v.isAuthorized() && !v.isUnauthorized()) {
				System.out.println(v);
			}
		}
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
