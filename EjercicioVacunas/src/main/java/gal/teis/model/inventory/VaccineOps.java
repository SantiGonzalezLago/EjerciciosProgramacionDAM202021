package gal.teis.model.inventory;

import java.util.ArrayList;
import java.util.Objects;

import gal.teis.model.vaccines.Vaccine;

public final class VaccineOps {

	public static final byte PENDING = 0;
	public static final byte AUTHORIZED = 1;
	public static final byte UNAUTHORIZED = 2;

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
		vaccine.setTestPhaseResult(phaseNumber, phaseCompleted);
	}

	public static void printVaccines() {
		// TODO ¿Atributos comunes a todas las vacunas?
		for (Vaccine v : warehouse) {
			System.out.println(v);
		}
	}

	public static void printVaccinesCodeName() {
		for (Vaccine v : warehouse) {
			StringBuilder sb = new StringBuilder();
			sb.append("Código: ");
			sb.append(v.getCode());
			sb.append(", nombre: ");
			sb.append(v.getName());
			sb.append(", aprobada: ");
			sb.append(v.isAuthorized() ? "SÍ" : "NO");
			System.out.println(sb.toString());
		}
	}

	public static void printAuthorizedVaccinesCodeName() {
		for (Vaccine v : warehouse) {
			if (v.isAuthorized()) {
				StringBuilder sb = new StringBuilder();
				sb.append("Código: ");
				sb.append(v.getCode());
				sb.append(", nombre: ");
				sb.append(v.getName());
				System.out.println(sb.toString());
			}
		}
	}

	public static void printUnauthorizedVaccinesCodeName() {
		for (Vaccine v : warehouse) {
			if (v.isUnauthorized()) {
				StringBuilder sb = new StringBuilder();
				sb.append("Código: ");
				sb.append(v.getCode());
				sb.append(", nombre: ");
				sb.append(v.getName());
				System.out.println(sb.toString());
			}
		}
	}

	public static void printPendingVaccinesCodeName() {
		for (Vaccine v : warehouse) {
			if (!v.isAuthorized() && !v.isUnauthorized()) {
				StringBuilder sb = new StringBuilder();
				sb.append("Código: ");
				sb.append(v.getCode());
				sb.append(", nombre: ");
				sb.append(v.getName());
				System.out.println(sb.toString());
			}
		}
	}

	public static byte isVaccineAuthorized(String code) {
		Vaccine vaccine = getVaccine(code);
		if (Objects.isNull(vaccine))
			throw new IllegalArgumentException("Esa vacuna no está en la base de datos");
		byte result = PENDING;
		if (vaccine.isAuthorized()) {
			result = AUTHORIZED;
		} else if (vaccine.isUnauthorized()) {
			result = UNAUTHORIZED;
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

	// La clase utilizará métodos estáticos, añado un constructor privado para que no se pueda instanciar
	private VaccineOps() {
	}

}
