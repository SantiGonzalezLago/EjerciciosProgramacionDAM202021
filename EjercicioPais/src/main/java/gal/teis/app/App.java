package gal.teis.app;

import java.util.InputMismatchException;

import gal.chanchi.scanner.KeyboardScanner;
import gal.teis.menu.Menu;
import gal.teis.model.Country;
import gal.teis.model.GovernmentSystem;

//Inicia desde aquí para acceder a la interfaz de comandos,
//o desde gal.teis.gui.MainWindow para acceder a la interfaz gráfica
public class App {

	private static KeyboardScanner sc = new KeyboardScanner();
	private static Menu mainMenu = new Menu("Crear país", "Ver paises");
	private static Menu creationMenu = new Menu("Con nombre", "Con nombre y capital",
			"Con nombre, capital y sistema de gobierno");

	public static void main(String[] args) {
		int option;
		boolean exit = false;
		do {
			try {
				mainMenu.printMenu();
				option = sc.nextInt();
				switch (option) {
				case 1:
					createCountry();
					break;
				case 2:
					listCountries();
					break;
				case 3:
					System.out.println("Hasta la próxima");
					exit = true;
					break;
				default:
					System.out.println("Opción no válida");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes introducir un valor numérico");
			}
		} while (!exit);
	}

	private static void createCountry() {
		int option;
		try {
			creationMenu.printMenu();
			option = sc.nextInt();
			switch (option) {
			case 1:
				createCountry(false, false);
				break;
			case 2:
				createCountry(true, false);
				break;
			case 3:
				createCountry(true, true);
				break;
			case 4:
				System.out.println("Volviendo al menú principal");
				break;
			default:
				System.out.println("Opción no válida");
			}
		} catch (InputMismatchException e) {
			System.out.println("Debes introducir un valor numérico");
		}
	}

	private static void createCountry(boolean requiresCapital, boolean requiresGovernment) {
		Country newCountry;
		String name, capital = null;
		GovernmentSystem government = null;
		System.out.println("Introduzca el nombre:");
		name = sc.nextLine();
		if (requiresCapital) {
			System.out.println("Introduzca la capital:");
			capital = sc.nextLine();
		}
		if (requiresGovernment) {
			System.out.println("Introduzca el gobierno ('R' para república o 'M' para monarquía):");
			while (government == null) {
				try {
					char govChar = Character.toUpperCase(sc.nextChar());
					switch (govChar) {
					case 'R':
						government = GovernmentSystem.REPUBLIC;
						break;
					case 'M':
						government = GovernmentSystem.MONARCHY;
						break;
					default:
						System.out.println("Introduzca 'R' o 'M'");
					}
				} catch (StringIndexOutOfBoundsException e) {
					System.out.println("Introduzca 'R' o 'M'");
				}
			}
		}
		if (requiresCapital) {
			if (requiresGovernment) {
				newCountry = new Country(name, capital, government);
			} else {
				newCountry = new Country(name, capital);
			}
		} else {
			newCountry = new Country(name);
		}
		Country.countryList.add(newCountry);
		System.out.println("Operación completada con éxito");
	}

	private static void listCountries() {
		for (Country c : Country.countryList) {
			System.out.println(c);
		}
	}
}
