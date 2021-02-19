package gal.teis.model;

import java.util.Scanner;

import gal.teis.main.DataControl;

public enum Color {
	BLACK("Negro"), WHITE("Blanco"), SILVER("Plateado"), BLUE("Azul"), YELLOW("Amarillo");

	private String localizedName;

	private Color(String localizedName) {
		this.localizedName = localizedName;
	}

	@Override
	public String toString() {
		return localizedName;
	}

	public static Color chooseColor(Scanner sc) {
		Color chosenColor = null;
		System.out.println("Elija un color: ");
		System.out.println("1. " + BLACK);
		System.out.println("2. " + WHITE);
		System.out.println("3. " + SILVER);
		System.out.println("4. " + BLUE);
		System.out.println("5. " + YELLOW);
		while (chosenColor == null) {
			int option = DataControl.nextInt(sc);
			chosenColor = switch (option) {
			case 1 -> BLACK;
			case 2 -> WHITE;
			case 3 -> SILVER;
			case 4 -> BLUE;
			case 5 -> YELLOW;
			default -> {
				System.out.println("Opción no válida");
				yield null;
			}
			};
		}
		return chosenColor;
	}
}
