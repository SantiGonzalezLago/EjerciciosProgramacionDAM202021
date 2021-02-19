package gal.teis.main;

import java.util.Scanner;

import gal.teis.model.*;

public class App {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WindowA.setPrice(49.99);
		WindowB.setPrice(29.99);
		int option = -1;
		while (option != 5) {
			System.out.println("Elija una opción: ");
			System.out.println("1. Fabricar ventanas");
			System.out.println("2. Vender ventanas");
			System.out.println("3. Ver stock");
			System.out.println("4. Ver histórico de ventas");
			System.out.println("5. Salir");
			option = DataControl.nextInt(sc);
			switch (option) {
			case 1 -> craftWindows();
			case 2 -> sellWindows();
			case 3 -> printStock();
			case 4 -> printTotalSold();
			case 5 -> System.out.println("Adios");
			default -> System.out.println("Opción no válida");
			}
			System.out.println();
		}
	}

	private static void craftWindows() {
		int option, amount;
		char type = '-';
		System.out.println("¿Qué tipo de ventanas quiere fabricar?");
		System.out.println("1. Tipo A");
		System.out.println("2. Tipo B");
		while (type == '-') {
			option = DataControl.nextInt(sc);
			switch (option) {
			case 1:
				type = 'A';
				break;
			case 2:
				type = 'B';
				break;
			default:
				System.out.println("Opción no válida");
			}
		}
		System.out.println("¿Cuántas ventanas va a fabricar?");
		do {
			amount = DataControl.nextInt(sc);
			if (amount <= 0) {
				System.out.println("El valor debe ser mayor que 0");
			}
		} while (amount <= 0);
		Color color = Color.chooseColor(sc);
		for (int i = 0; i < amount; i++) {
			if (type == 'A') {
				new WindowA(color);
			} else if (type == 'B') {
				new WindowB(color);
			}
		}
	}

	private static void sellWindows() {
		int option, amount;
		char type = '-';
		System.out.println("¿Qué tipo de ventanas quiere vender?");
		System.out.println("1. Tipo A");
		System.out.println("2. Tipo B");
		while (type == '-') {
			option = DataControl.nextInt(sc);
			switch (option) {
			case 1:
				type = 'A';
				break;
			case 2:
				type = 'B';
				break;
			default:
				System.out.println("Opción no válida");
			}
		}
		System.out.println("¿Cuántas ventanas va a vender?");
		do {
			amount = DataControl.nextInt(sc);
			if (amount <= 0) {
				System.out.println("El valor debe ser mayor que 0");
			}
		} while (amount <= 0);
		Color color = Color.chooseColor(sc);
		// Con el operador &&, la parte de la derecha solo se ejecuta si la parte izquierda es true,
		// así que solo se intentará realizar la venta si el tipo es correcto.
		if (type == 'A' && WindowA.sellWindows(amount, color)) {
			System.out.println("Se han vendido " + amount + " ventanas " + color + " del tipo A");
			System.out.println("Precio unitario: " +  WindowA.getPrice() + "€");
			System.out.println("Precio total: " +  WindowA.getPrice() * amount + "€");
		} else if (type == 'B' && WindowB.sellWindows(amount, color)) {
			System.out.println("Se han vendido " + amount + " ventanas " + color + " del tipo B");
			System.out.println("Precio unitario: " +  WindowB.getPrice() + "€") ;
			System.out.println("Precio total: " +  WindowB.getPrice() * amount + "€");
		} else {
			System.out.println("No ha suficientes ventanas en stock para realizar la venta");
		}
	}

	private static void printStock() {
		System.out.println("Stock disponible: ");
		for (Color color : Color.values()) { 
			System.out.println("Tipo A, " + color + ": " + WindowA.getStock(color));
		}
		for (Color color : Color.values()) { 
			System.out.println("Tipo B, " + color + ": " + WindowB.getStock(color));
		}
	}

	private static void printTotalSold() {
		System.out.println("Histórico de ventas: ");
		System.out.println("Tipo A: " + WindowA.getTotalSold());
		System.out.println("Tipo B: " + WindowB.getTotalSold());
	}
}
