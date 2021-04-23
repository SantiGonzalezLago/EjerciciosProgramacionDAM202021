package gal.teis.app;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Scanner;

import gal.teis.model.inventory.VaccineWarehouse;
import gal.teis.model.vaccines.*;

public class App {

	private static final String VACCINE_NO_EXISTS = "No existe una vacuna con ese código en el almacén.";
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
		if (TestMode.ENABLED)
			TestMode.initializeTestValues();

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
		case 6:
			authorizeRejectVaccine();
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
		case 10:
			checkLastPhaseOfEachVaccine();
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
			System.out.println(VACCINE_NO_EXISTS);
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
			// No debería llegar aquí nunca, llamo a printStackTrace() por si llegase
			// durante las pruebas
		}
	}

	private static void removeVaccine() {
		System.out.println("Introduzca el código de la vacuna:");
		String code = readCode();
		if (VaccineWarehouse.remove(code)) {
			System.out.println("Se ha eliminado la vacuna.");
		} else {
			System.out.println(VACCINE_NO_EXISTS);
		}
	}

	private static void addTestResults() {
		System.out.println("Introduzca el código de la vacuna:");
		Vaccine vaccine = VaccineWarehouse.getVaccine(readCode());
		if (Objects.isNull(vaccine)) {
			System.out.println(VACCINE_NO_EXISTS);
		} else {
			System.out.println("Introduzca el número de fase a introducir");
			byte phaseNum = scNum.readByte();
			boolean result = readResult();
			try {
				vaccine.setTestPhaseResult(phaseNum, result);
			} catch (IllegalAccessException | IllegalArgumentException e) {
				System.out.printf("Error: %s%n", e.getMessage());
			}
		}
	}

	private static boolean readResult() {
		boolean error;
		boolean result = false;
		do {
			error = false;
			System.out.println("Introduzca el resultado de la fase");
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

	private static void authorizeRejectVaccine() {
		System.out.println("Introduzca el código de la vacuna:");
		Vaccine vaccine = VaccineWarehouse.getVaccine(readCode());
		if (Objects.isNull(vaccine)) {
			System.out.println(VACCINE_NO_EXISTS);
		} else if (vaccine.isAuthorized() || vaccine.isUnauthorized()) {
			System.out.println("Esa vacuna no está pendiente de autorización");
		} else {
			byte option = 0;
			while (option != 1 && option != 2) {
				System.out.println("¿Desea autorizar o rechazar la vacuna?");
				System.out.println("1. Autorizar");
				System.out.println("2. Rechazar");
				option = scNum.readByte();
			}
			boolean success = false;
			System.out.printf("¿Está seguro de que quiere %s la vacuna %s? (S/N)%n",
					(option == 1 ? "autorizar" : "rechazar"), vaccine.getCode());
			if (confirm()) {
				success = switch (option) {
				case 1 -> vaccine.authorize();
				case 2 -> vaccine.reject();
				default -> false;
				};
			}
			if (success) {
				System.out.printf("Se ha %s la vacuna%n", (option == 1 ? "autorizado" : "rechazado"));
			} else {
				System.out.printf("No se ha %s la vacuna%n", (option == 1 ? "autorizado" : "rechazado"));
			}
		}
	}

	private static boolean confirm() {
		boolean success = false;
		boolean yes = false;
		while (!success) {
			try {
				char input = sc.nextLine().toUpperCase().charAt(0);
				if (input == 'S') {
					yes = true;
					success = true;
				} else if (input == 'N') {
					yes = false;
					success = true;
				} else {
					System.out.println("Introduzca S o N");
				}
			} catch (StringIndexOutOfBoundsException ex) {
			}
		}
		return yes;
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

	private static void checkLastPhaseOfEachVaccine() {
		VaccineWarehouse.printLastCompletedPhaseOfEachVaccine();
	}
}
