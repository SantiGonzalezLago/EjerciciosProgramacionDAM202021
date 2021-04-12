package gal.teis.app;

import java.util.Scanner;

public class App {

	private static Scanner sc;
	private static NumericScanner scNum;

	private static final String[] MENU_OPTIONS = {
			"Buscar vacuna", // 1
			"Agregar vacuna", // 2
			"Eliminar vacuna", // 3
			"Introducir resultado de las fases de una vacuna", // 4
			"Ver vacunas autorizadas", // 5
			"Ver vacunas no autorizadas", // 6
			"Ver vacunas pendientes de autorizar o rechazar", // 7
			"Salir" // 8
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
            	break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
            	repeatMenu = false;
        }
        
        return repeatMenu;
	}

	public static byte readOption() {
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

}
