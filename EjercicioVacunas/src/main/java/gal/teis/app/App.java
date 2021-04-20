package gal.teis.app;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Scanner;

import gal.teis.model.inventory.VaccineWarehouse;
import gal.teis.model.vaccines.*;

public class App {

	private static Scanner sc;
	private static NumericScanner scNum;

	private static final String[] MENU_OPTIONS = { "Listar todas las vacunas", // 1
			"Buscar vacuna", // 2
			"Agregar vacuna", // 3
			"Eliminar vacuna", // 4
			"Introducir resultado de las fases de una vacuna", // 5
			"Autorizar/rechazar vacuna", // 6
			"Ver vacunas autorizadas", // 7
			"Ver vacunas no autorizadas", // 8
			"Ver vacunas pendientes de autorizar o rechazar", // 9
			"Ver la última fase investigada de cada vacuna almacenada", // 10
			"Salir" // 11
	};

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		scNum = new NumericScanner(sc);

		System.out.println("Bienvenido a la aplicación de gestión de vacunas");
		while (menu()) {
			System.out.println("Pulsa Enter para continuar");
			sc.nextLine();
		}
		System.out.println("Hasta la próxima");
	}

	private static boolean menu() {
		boolean repeatMenu = true;

		System.out.println("Elija una opción:");
		for (int i = 0; i < MENU_OPTIONS.length; i++) {
			System.out.println((i + 1) + ". " + MENU_OPTIONS[i]);
		}

		switch (readOption()) {
		case 1:
			listAllVaccines();
			break;
		case 2:
			findVaccine();
			break;
		case 3:
			addVaccine();
			break;
		case 4:
			removeVaccine();
			break;
		case 5:
			addTestResults();
			break;
		case 7:
			listAuthorizedVaccines();
			break;
		case 8:
			listUnauthorizedVaccines();
			break;
		case 9:
			listPendingVaccines();
			break;
		case 11:
			repeatMenu = false;
		}

		return repeatMenu;
	}

	private static byte readOption() {
		boolean error;
		byte option = 0;

		do {
			error = false;
			option = scNum.readByte();
			if (option <= 0 || option > MENU_OPTIONS.length) {
				System.out.println("Debe introducir un valor entre 1 y " + MENU_OPTIONS.length);
				error = true;
			}
		} while (error);

		return option;
	}

	private static String readCode() {
		boolean error;
		String code = null;
		do {
			error = false;
			code = sc.nextLine();
			if (!Vaccine.isCodeValid(code)) {
				System.out.println(
						"El código no es válido, debe empezar por V seguida de una vocal mayúscula, continuar con 3 o 4 letras minúsculas y terminar por 2 dígitos o un 8.");
				error = true;
			}
		} while (error);
		return code;
	}

	private static Class<? extends Vaccine> readVaccineClass() {
		Class<? extends Vaccine> type = null;
		while (Objects.isNull(type)) {
			System.out.println("Elija el tipo de vacuna");
			System.out.println("1. Janssen (Johnson & Johnson)");
			System.out.println("2. Moderna");
			System.out.println("3. Pfizer-BioNTech");
			System.out.println("4. Soberana 02");
			type = switch (readOption()) {
			case 1 -> JanssenVaccine.class;
			case 2 -> ModernaVaccine.class;
			case 3 -> PfizerVaccine.class;
			case 4 -> SoberanaVaccine.class;
			default -> {
				System.out.println("Opción no válida");
				yield null;
			}
			};
		}
		return type;
	}

	private static void findVaccine() {
		System.out.println("Introduzca el código de la vacuna:");
		String code = readCode();
		Vaccine vaccine = VaccineWarehouse.getVaccine(code);
		if (Objects.nonNull(vaccine)) {
			System.out.println(vaccine);
		} else {
			System.out.println("No existe una vacuna con ese código en el almacén.");
		}
	}

	private static void addVaccine() {
		try {
			var vaccineType = readVaccineClass();
			System.out.println("Introduzca el código:");
			String code = readCode();
			Vaccine vaccine = (Vaccine) vaccineType.getConstructor(String.class).newInstance(code);
			if (VaccineWarehouse.add(vaccine)) {
				System.out.println("Se ha añadido la vacuna.");
			} else {
				System.out.println("No se ha podido añadir la vacuna.");
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			// No debería llegar aquí nunca
		}
	}

	private static void removeVaccine() {
		System.out.println("Introduzca el código de la vacuna:");
		String code = readCode();
		if (VaccineWarehouse.remove(code)) {
			System.out.println("Se ha eliminado la vacuna.");
		} else {
			System.out.println("No existe una vacuna con ese código en el almacén.");
		}
	}

	private static void addTestResults() {
		System.out.println("Introduzca el código de la vacuna:");
		String code = readCode();
		boolean[] results = new boolean[3];
		System.out.println("Introduzca el número de fase a introducir");
		System.out.println("Si quiere introducir varias, escriba los números juntos (por ejemplo, 123)");
		for (int i = 1; i <= 3; i++) {
			if (code.contains("" + i)) {
				results[i - 1] = readResult("Introduzca el resultado de la fase " + i);
			}
		}
		try {
			for (byte i = 1; i <= 3; i++) {
				if (code.contains("" + i)) {
					VaccineWarehouse.insertTestPhaseResult(code, i, results[i - 1]);
				}
			}
		} catch (IllegalArgumentException ex) {
			System.out.println("No existe una vacuna con ese código en el almacén.");
		}
	}

	private static boolean readResult(String msg) {
		boolean error;
		boolean result = false;
		do {
			error = false;
			System.out.println(msg);
			System.out.println("1. Superada");
			System.out.println("2. Fallida");
			switch (scNum.readByte()) {
			case 1:
				result = true;
				break;
			case 2:
				result = false;
				break;
			default:
				error = true;
				System.out.println("Introduzca 1 o 2");
			}
		} while (error);
		return result;

	}

	private static void listAllVaccines() {
		System.out.println("Todas las vacunas:");
		VaccineWarehouse.printVaccines();
	}

	private static void listAuthorizedVaccines() {
		System.out.println("Vacunas autorizadas:");
		VaccineWarehouse.printAuthorizedVaccines();
	}

	private static void listUnauthorizedVaccines() {
		System.out.println("Vacunas no autorizadas:");
		VaccineWarehouse.printUnauthorizedVaccines();
	}

	private static void listPendingVaccines() {
		System.out.println("Vacunas pendientes:");
		VaccineWarehouse.printPendingVaccines();
	}

}
