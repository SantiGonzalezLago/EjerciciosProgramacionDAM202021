package gal.teis.app;

/**
 * <h2>Help</h2>
 * 
 * Esta clase muestra información para el usuario acerca de las distintas opciones de la aplicación
 * 
 * @author Santiago González Lago
 */
public class Help {

	public static void getHelp(int option) {
		System.out.println("Bienvenido al sistema de ayuda");
		System.out.printf("Opción %d: %s%n", option, App.MENU_OPTIONS[option-1]);
		switch (option) {
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
			exit();
		}
	}

	private static void exit() {
		System.out.println("Finaliza la aplicación.");
	}

	private static void checkLastPhaseOfEachVaccine() {
		System.out.println("Muestra la última fase completada de todas las vacunas del almacén.");
	}

	private static void listPendingVaccines() {
		System.out.println("Muestra los datos de todas las vacunas en el almacén que están pendientes de autorización.");
	}

	private static void listUnauthorizedVaccines() {
		System.out.println("Muestra los datos de todas las vacunas en el almacén que han sido rechazadas.");
	}

	private static void listAuthorizedVaccines() {
		System.out.println("Muestra los datos de todas las vacunas en el almacén que han sido autorizadas.");
	}

	private static void authorizeRejectVaccine() {
		System.out.println("Solicita el código de una vacuna. Si existe, la aplicación pregunta si se desea autorizar o rechazar.");
		System.out.println("Tras recibir confirmación, se intentará realizar la operación de autorización o rechazo.");
		System.out.println("Recuerde que solo se puede autorizar o rechazar una vacuna pendiente de autorización, y que solo se pueden autorizar vacunas que han superado todas las fases de pruebas.");
	}

	private static void addTestResults() {
		System.out.println("Solicita el código de una vacuna, el número de fase a introducir y el resultado.");
		System.out.println("El número de fase solo se solicita como comprobación, ya que la aplicación devolverá un error si es distinto del esperado.");
		System.out.println("Si la vacuna existe y la fase es correcta, introducirá el resultado");
	}

	private static void removeVaccine() {
		System.out.println("Solicita el código de una vacuna y, si existe, la elimina del almacén");
	}

	private static void addVaccine() {
		System.out.println("Solicita el código y el tipo de una nueva vacuna y la añade, a no ser que ya exista una vacuna con ese código");
	}

	private static void findVaccine() {
		System.out.println("Solicita el código de una vacuna y, si existe, muestra sus datos");
	}

	private static void listAllVaccines() {
		System.out.println("Muestra los datos de todas las vacunas en el almacén");
	}
}
