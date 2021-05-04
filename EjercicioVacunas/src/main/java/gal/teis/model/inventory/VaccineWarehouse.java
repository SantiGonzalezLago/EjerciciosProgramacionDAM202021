package gal.teis.model.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import gal.teis.model.vaccines.Vaccine;

/**
 * <h2>VaccineWarehouse</h2>
 * 
 * Esta clase contiene métodos estáticos para el manejo del almacén
 * 
 * @author Santiago González Lago
 */
public final class VaccineWarehouse {

	private static Map<String, Vaccine> warehouse = new HashMap<>();

	/**
	 * @return La cantidad de vacunas en el almacén
	 */
	public int getTotal() {
		return warehouse.size();
	}

	/**
	 * Permite introducir una vacuna en el almacén, siempre que el código no esté duplicado
	 * 
	 * @param vaccine La vacuna a introducir
	 * @return true si se ha introducido con éxito, false si no se ha podido introducir
	 */
	public static boolean add(Vaccine vaccine) {
		boolean success = false;
		if (Objects.isNull(warehouse.get(vaccine.getCode()))) {
			warehouse.put(vaccine.getCode(), vaccine);
			success = true;
		}
		return success;
	}

	/**
	 * Permite eliminar una vacuna del almacén
	 * 
	 * @param code El código de la vacuna a eliminar
	 * @return true si se ha eliminado, false si no existe
	 */
	public static boolean remove(String code) {
		return Objects.nonNull(warehouse.remove(code));
	}

	/**
	 * @return Un array con todas las vacunas
	 */
	public static Vaccine[] getVaccines() {
		return warehouse.values().toArray(new Vaccine[warehouse.size()]);
	}

	/**
	 * @return Un List con todas las vacunas autorizadas
	 */
	public static List<Vaccine> getAuthorizedVaccines() {
		var authVaccines = new ArrayList<Vaccine>();
		for (Vaccine v : warehouse.values()) {
			if (v.isAuthorized()) {
				authVaccines.add(v);
			}
		}
		return authVaccines;
	}

	/**
	 * @return Un List con todas las vacunas rechazadas
	 */
	public static List<Vaccine> getUnauthorizedVaccines() {
		var unauthVaccines = new ArrayList<Vaccine>();
		for (Vaccine v : warehouse.values()) {
			if (v.isUnauthorized()) {
				unauthVaccines.add(v);
			}
		}
		return unauthVaccines;
	}

	/**
	 * @return Un List con todas las vacunas pendientes de autorización
	 */
	public static List<Vaccine> getPendingVaccines() {
		var pendingVaccines = new ArrayList<Vaccine>();
		for (Vaccine v : warehouse.values()) {
			if (!v.isAuthorized() && !v.isUnauthorized()) {
				pendingVaccines.add(v);
			}
		}
		return pendingVaccines;
	}

	/**
	 * @param code El código de la vacuna solicitada
	 * @return La vacuna solicitada
	 */
	public static Vaccine getVaccine(String code) {
		return warehouse.get(code);
	}

	/**
	 * La clase utilizará métodos estáticos, añado un constructor privado para que  no se pueda instanciar
	 */
	private VaccineWarehouse() {
	}

}
