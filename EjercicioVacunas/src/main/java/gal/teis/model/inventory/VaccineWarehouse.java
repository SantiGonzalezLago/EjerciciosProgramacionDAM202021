package gal.teis.model.inventory;

import java.util.ArrayList;
import java.util.Objects;

import gal.teis.model.vaccines.Vaccine;
import gal.teis.model.vaccines.VaccineAuthorization;

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

	public static void insertTestPhaseResult(String code, byte phaseNumber, boolean phaseCompleted) {
		Vaccine vaccine = getVaccine(code);
		if (Objects.isNull(vaccine))
			throw new IllegalArgumentException("Esa vacuna no está en la base de datos");
		try {
			vaccine.setTestPhaseResult(phaseNumber, phaseCompleted);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
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

	public static byte isVaccineAuthorized(String code) {
		Vaccine vaccine = getVaccine(code);
		if (Objects.isNull(vaccine))
			throw new IllegalArgumentException("Esa vacuna no está en la base de datos");
		byte result = VaccineAuthorization.PENDING;
		if (vaccine.isAuthorized()) {
			result = VaccineAuthorization.AUTHORIZED;
		} else if (vaccine.isUnauthorized()) {
			result = VaccineAuthorization.UNAUTHORIZED;
		}
		return result;
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
